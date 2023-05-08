package com.example.spotyceri;

import android.Manifest;
import android.app.Activity;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;

import java.io.File;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {

    //ICE Declare
    Communicator communicator;
    com.zeroc.Ice.ObjectPrx obj;
    app.StreamApplicationPrx printer;


    private EditText nameEditText;
    private Button playButton;


    private TextView tv, playing;
    private Button buttonSend;
    private Button executebtn;


    private MyApiService myApiService;


    // Recording :
    private static int MICROPHONE_PERMISSION_CODE = 200;

    MediaRecorder mediaRecorder;

    private MediaPlayer mediaPlayer;


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };


    @Override
    protected void onResume() {
        super.onResume();
        verifyStoragePermissions(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Implmentation Ice

        // Implmentation Ice
        try {


            communicator = Util.initialize();
            obj = communicator.stringToProxy("StreamApplication:tcp -h 192.168.0.27 -p 10000");
            printer = app.StreamApplicationPrx.checkedCast(obj);
            //printer.printString("Test de Connexion android");
            SweetAlertDialog sDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.NORMAL_TYPE);
            sDialog.setTitleText(" Bonne Nouvelle!!!");
            sDialog.setContentText("Connexion au serveur ICE avec succès");
            sDialog.setCancelable(true);
            sDialog.show();


        } catch (Exception e) {
            e.printStackTrace();
            SweetAlertDialog sDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE);
            sDialog.setContentText("Erreur de connexion au serveur ICE");
            sDialog.setCancelable(true);
            sDialog.show();
        }


        //Partie Recording Audio
        if (isMicrophonePresent()) {
            getMicrophonePermission();
        }


        // Send Data to Server
        verifyStoragePermissions(this);
        // Request the permission at runtime

        try {


            // Create a TrustAllCerts TrustManager that trusts all certificates
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };


            // Create an SSLContext that uses our TrustAllCerts TrustManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());


            // Create an OkHttpClient that uses the SSLContext and disables certificate validation
            OkHttpClient client = new OkHttpClient.Builder()
                    .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier((hostname, session) -> true)
                    .build();

            tv = findViewById(R.id.tv);

            playing = findViewById(R.id.playing);

            buttonSend = findViewById(R.id.button_send);


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://192.168.0.27:3000/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            myApiService = retrofit.create(MyApiService.class);

            buttonSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    File audioFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "test.mp3");


                    // create a RequestBody object from the audio file
                    RequestBody audioRequestBody = RequestBody.create(MediaType.parse("audio/mpeg"), getRecordingFilePath());

                    // create a MultipartBody.Part object from the RequestBody object
                    MultipartBody.Part audioPart = MultipartBody.Part.createFormData("audio", getRecordingFilePath().getName(), audioRequestBody);


                    Call<MyResponse> call = myApiService.uploadAudio(audioPart, audioRequestBody);

                    call.enqueue(new Callback<MyResponse>() {
                        @Override
                        public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                            if (response.isSuccessful()) {
                                MyResponse myResponse = response.body();
                                Toast.makeText(MainActivity.this, myResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                tv.setText(myResponse.getMessage());

                                Log.i("MainActivity", myResponse.getMessage());
                            } else {
                                Toast.makeText(MainActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                                Log.e("MainActivity", "Error: " + response.code());
                                tv.setText("Error: " + response.code());
                            }
                        }

                        @Override
                        public void onFailure(Call<MyResponse> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            tv.setText("Error: " + t.getMessage());
                        }
                    });
                }
            });


        } catch (Exception e) {
            e.fillInStackTrace();
        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Clean up ICE communicator
        if (communicator != null) {
            communicator.destroy();
        }
    }


    // Call this method from your onCreate() method to request the permission
    public void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission, so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


    // Recording Functions :

    public void onRecord(View v) {

        try {
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mediaRecorder.setOutputFile(getRecordingFilePath().getPath());

            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();
            mediaRecorder.start();

            Toast.makeText(this, "Recording is Started.....", Toast.LENGTH_LONG).show();

        } catch (Exception e) {

            e.printStackTrace();
        }


    }


    public void onStop(View v) {

        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;


        Toast.makeText(this, "Recording is Stopped", Toast.LENGTH_LONG).show();

    }

    public void onPlay(View v) {

        try {


            // Initialize LibVLC
            LibVLC libVLC = new LibVLC(getApplicationContext());

            // Create a MediaPlayer object and set the media to play
            mediaPlayer = new MediaPlayer(libVLC);
            Media media = new Media(libVLC, getRecordingFilePath().getPath());
            mediaPlayer.setMedia(media);

            media.release();
            mediaPlayer.play();

            Toast.makeText(this, "Recording is Playing", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean isMicrophonePresent() {
        if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            return true;
        } else {
            return false;
        }
    }


    private void getMicrophonePermission() {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) ==
                PackageManager.PERMISSION_DENIED) {

            ActivityCompat.requestPermissions(this, new String[]
                    {android.Manifest.permission.RECORD_AUDIO}, MICROPHONE_PERMISSION_CODE);

        }

    }


    private File getRecordingFilePath() {

        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File musicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(musicDirectory, "test" + ".mp3");

        return file;
    }


    // Execution of the ICE Commands

    public void onExecute(View v) {


        CharSequence text = tv.getText();
        String input = text.toString();

        String[] parts = input.split(",");
        String command = parts[0].replaceAll("<", "").trim(); // "play"
        String songName = parts[1].replaceAll(">", "").trim(); // "hôtel California"


        app.Song s1 = new app.Song("hôtel California", "file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC) + "/hôtel California.mp3", "artist 1", "album1", "genre1", "year1");
        app.Song s2 = new app.Song("hôtel California", "https://drive.google.com/file/d/1LkSgkE5i6c_WTrhonX9gE4ko3FIvsUWp/view?usp=share_link", "artist 2", "album2", "genre2", "year2");


        playing.setText(command);
        printer.ajoutMusic(s1);


            try {



                    // Initialize LibVLC
                    LibVLC libVLC = new LibVLC(getApplicationContext());

                    // Create a MediaPlayer object and set the media to play
                    mediaPlayer = new MediaPlayer(libVLC);
                    Media media = new Media(libVLC, Uri.parse(s1.path));
                    mediaPlayer.setMedia(media);

                    // Prepare the MediaPlayer and start playbac

                    printer.playStream(s1.path);
                    playing.setText(s1.name + " is Playing");

                    mediaPlayer.play();

                    Toast.makeText(this, s1.name + " is Playing", Toast.LENGTH_LONG).show();


            } catch (Exception e) {
                e.printStackTrace();
            }





    }
}

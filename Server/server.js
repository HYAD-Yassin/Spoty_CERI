const express = require('express');
const app = express();
const multer = require('multer');
const https = require('https');
const fs = require('fs');



const ffmpegPath = require('@ffmpeg-installer/ffmpeg').path;
const ffmpeg = require('fluent-ffmpeg');
ffmpeg.setFfmpegPath(ffmpegPath);


require('dotenv').config();



const speech = require('@google-cloud/speech');


const options = {
  key: fs.readFileSync('key.pem'),
  cert: fs.readFileSync('cert.pem')
};

const server = https.createServer(options, app);


app.use(express.static('public'));


server.listen(3000, () => {
  console.log('Server listening on port 3000...');
});

// For the Test
app.get('/', (req, res) => {
   
    console.log("Hello Hassan");
   
    res.send("Hello Hassan");

});
   

//Receive Files

const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, 'uploads/')
  },
  filename: function (req, file, cb) {
    cb(null, file.originalname)
  }
})

const upload = multer({ storage: storage })



// Recevoir le Audio et Faire la Transcription
app.post('/upload', upload.single('audio'), async function (req, res, next) {
  
// Le fichier Reçu
    console.log("Le fichier audio reçu : "+req.file.originalname);
     


  const inputFilePath = 'uploads/test.mp3';
  const outputFilePath = 'uploads/output.wav';

  
// Convert mp3 to wav
  ffmpeg(inputFilePath)
  .output(outputFilePath)
  .on('end', function() {
    console.log('Conversion finished');
    // Call your transcription service here with the WAV file
  })
  .on('error', function(err) {
    console.log('Error during conversion: ', err);
  })
  .run();


  const client = new speech.SpeechClient();

  const audio = {
    content: fs.readFileSync(outputFilePath).toString('base64'),
  };

  const config = {
    encoding: 'LINEAR16',
    sampleRateHertz: 8000,
    languageCode: 'fr-FR',
  };
  
  const request = {
    audio: audio,
    config: config,
  };

  client.recognize(request)
  .then(response => {
    const transcription = response[0].results
      .map(result => result.alternatives[0].transcript)
      .join('\n');
    console.log(`Transcription: ${transcription}`);

    //Apply Regex to the transcription
        const regex = new RegExp(/\bjouer\b/,"gi");

            regex.test(transcription);

            const Objet =  RegExp["$'"].trimStart();

            const Action = RegExp["$&"].replace(/\bjouer\b/, "play");



            const Commande = "<" + Action +","  + Objet +  ">";
            console.log(Commande);

   
    res.status(200).json({
      message: Commande
    });


  })
  .catch(err => {
    console.error('Error during transcription: ', err);
  });



}) 



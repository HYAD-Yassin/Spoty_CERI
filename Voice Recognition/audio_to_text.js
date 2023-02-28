const speech = require('@google-cloud/speech');
const fs = require ('fs');
const process = require('process'); // Include process module
  

async function main(){
    var args = process.argv;
    console.log("Le chemin vers votre fichier .wav "+args[2]);
    const client = new speech.SpeechClient();
   
    const filename = args[2] ;
    
    const file = fs.readFileSync(filename);
    const audioBytes = file.toString('base64') ;

    const audio ={
        content: audioBytes
    };
    const config = {
        encoding: 'LINEAR16',
        audioChannelCount:2,
        sampleRateHertz: 48000, 
        languageCode:'FR'
    };
    const request = {
        audio: audio,
        config: config
    };

    const [response] = await client.recognize(request);
    const transcription = response.results.map(
        result =>result.alternatives[0].transcript).join('\n');
        console.log('Transcription de l audio: ', transcription);

}
main().catch(console.error);

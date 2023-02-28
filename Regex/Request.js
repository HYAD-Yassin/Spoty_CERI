const request = "jouer hotêl California";


const regex = new RegExp(/\bjouer\b/,"gi");

regex.test(request);

const Objet =  RegExp["$'"].trimStart();

const Action = RegExp["$&"].replace(/\bjouer\b/, "play");



const Commande = "<" + Action +" ,"  + Objet +  ">";
console.log(Commande);
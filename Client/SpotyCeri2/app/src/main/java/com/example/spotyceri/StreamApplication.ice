module app {
 
 class Song{
	        string name;
	        string path;
	        string artist;
	        string album;
	        string genre;
	        string year;
    	}	
    
 sequence<Song> songList;
 
 interface StreamApplication {
 			bool ajoutMusic(Song s);
 			bool suppMusic(string name);
			Song playStream(string nom);
 			songList findByName(string nom);
 			songList findByAlbum(string album);
 			songList findByArtist(string artist);
 			songList findByGenre(string genre);
 			songList findByYear(string year);
 			songList getAll();
 };
};

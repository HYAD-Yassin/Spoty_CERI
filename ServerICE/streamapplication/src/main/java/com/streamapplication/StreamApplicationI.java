package com.streamapplication;

import java.util.ArrayList;

import com.zeroc.Ice.Current;

import app.Song;

public class StreamApplicationI implements app.StreamApplication {
	
	private ArrayList<Song> songList = new ArrayList<>();
	
	@Override
	public boolean ajoutMusic(Song s, Current current) {
		
		songList.add(s);
		System.out.println("Song "+s.name+"added !");
		
		return true;
	}
	@Override
	public boolean suppMusic(String musicName, Current current) {
		int index=0;
		for(Song s : songList) {
			if(s.name.equals(musicName))
			{
				songList.remove(index);
				
				return true;
			}
			index++;
		}
		return false;
		
	}
	@Override
    public Song playStream(String song,Current current) {
		for (Song s : songList) {
            if (s.name.equals(song)) {
				System.out.println("Song "+s.name+" is playing!");
                return s;
            }
        }
        return null;
    }

	public boolean findByName(String nom, Current current)
		{
			for(Song song : songList) {
			
				if(song.name.equals(nom)) {
					System.out.println("Song "+song.name+" trouvé !");
					return true;
				}
			}
			return false;
		}

	@Override
	public Song[] findByAlbum(String album, Current current) {
		
		ArrayList<Song> songlisttmp = new ArrayList<>();
		for(Song s: songList) {
			if(s.album.equals(album))
			songlisttmp.add(s);
		}
		
		return songlisttmp.toArray(new Song[0]);
	}
	@Override
	public Song[] findByArtist(String artist, Current current) {
		ArrayList<Song> songlisttmp = new ArrayList<>();
		for(Song s: songList) {
			if(s.artist.equals(artist))
			songlisttmp.add(s);
		}
		
		return songlisttmp.toArray(new Song[0]);
	}
	@Override
	public Song[] findByGenre(String genre, Current current) {
		ArrayList<Song> songlisttmp = new ArrayList<>();
		for(Song s: songList) {
			if(s.genre.equals(genre))
			songlisttmp.add(s);
		}
		
		return songlisttmp.toArray(new Song[0]);
	}
	@Override
	public Song[] findByYear(String year, Current current) {
		ArrayList<Song> songlisttmp = new ArrayList<>();
		for(Song s: songList) {
			if(s.year.equals (year))
			songlisttmp.add(s);
		}
		
		return songlisttmp.toArray(new Song[0]);
	};
	
	@Override
	public Song[] getAll(Current current) {
		ArrayList<Song> songlisttmp = new ArrayList<>();
		for(Song s: songList) {
			songlisttmp.add(s);
		}
		return songlisttmp.toArray(new Song[0]);
	}


}
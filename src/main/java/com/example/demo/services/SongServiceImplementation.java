package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositrories.Songrepository;

@Service
public class SongServiceImplementation implements SongService{

	@Autowired
	Songrepository repo;
	
	
	@Override
	public void addSong(Song song) {
		repo.save(song);
	}


	@Override
	public List<Song> viewSongs() {
		return repo.findAll();
	}


	@Override
	public boolean songExists(String name) {
		List<Song> song = repo.findByName(name);
		return !song.isEmpty();
		
		
	}

	@Override
	public void updateSong(Song s) {
		repo.save(s);
	}


	
}

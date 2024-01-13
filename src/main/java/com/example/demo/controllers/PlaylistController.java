package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;


@Controller
public class PlaylistController {

	@Autowired
	SongService service;
	
	@Autowired
	PlaylistService playlistService;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Song> songList = service.viewSongs();
		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
	
	@GetMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {

		//Update play list table
		
		playlistService.addPlaylist(playlist);

		//Update Song table
		List<Song> songList = playlist.getSongs();
		
		for(Song s:songList) {
			s.getPlaylist().add(playlist);

			//Update Song object in db
			service.updateSong(s);
		}
		return "adminHome";
	}
	
	@GetMapping("viewPlaylist")
	public String viewPlaylist(Model model) {
		
		List<Playlist> listPlaylist=playlistService.viewPlaylist();
		model.addAttribute("listPlaylist", listPlaylist);
		return "displayPlaylist";
	}
	
	
	
	
	
}

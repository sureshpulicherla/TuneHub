package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongController {

	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		boolean songStatus = service.songExists(song.getName());
		if(songStatus == false) {
			service.addSong(song);
			System.out.println("Song added succesfully");
		}else {
			System.out.println("Song already existed");
		}
		return "adminHome";
	}

	
	@GetMapping("/viewSongs")
	public String viewSong(Model model) {
		List<Song> songList=service.viewSongs();
		System.out.println(songList);
		model.addAttribute("songs", songList);
		return "displaySongs";
	}
	
	
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		boolean premiumUser = true;
		if(premiumUser == true) {
			List<Song> songList=service.viewSongs();
			model.addAttribute("songs", songList);
			return "displaySongs";
		}else {
			return "makePayment";
		}
		
	}
}

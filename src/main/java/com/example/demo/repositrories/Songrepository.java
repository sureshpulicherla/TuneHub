package com.example.demo.repositrories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Song;

public interface Songrepository extends JpaRepository<Song, Integer>{

	List findByName(String name);

	
}

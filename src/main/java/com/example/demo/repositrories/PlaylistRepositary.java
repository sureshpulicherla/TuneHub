package com.example.demo.repositrories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Playlist;

public interface PlaylistRepositary extends JpaRepository<Playlist, Integer>{

}

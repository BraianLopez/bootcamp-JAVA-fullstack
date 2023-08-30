package com.codingdojo.laboratoriodecanciones.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.laboratoriodecanciones.models.Song;
import com.codingdojo.laboratoriodecanciones.repos.SongRepo;

@Service
public class SongService {
//INYECCION DEPENDENCIAS
	private SongRepo songRepo;
	public SongService(SongRepo sRe) {
		this.songRepo = sRe;
	}
	
	public Song createSong(Song song) {
	return songRepo.save(song);	
	}
	public Song editSong(Song song) {
		return songRepo.save(song);	
		}
	public List<Song> todasCanciones() {
		return songRepo.findAll();	
	}
	public Song unaCancion(Long id) {
		return songRepo.findById(id).orElse(null);	
	}
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
}

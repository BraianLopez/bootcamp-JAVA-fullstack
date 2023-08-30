package com.codingdojo.laboratoriodecanciones.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.laboratoriodecanciones.models.Song;

public interface SongRepo  extends CrudRepository<Song, Long>{

	
	
	List<Song> findAll();
}

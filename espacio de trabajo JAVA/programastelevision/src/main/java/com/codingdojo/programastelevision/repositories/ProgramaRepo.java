package com.codingdojo.programastelevision.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.programastelevision.models.Programa;

public interface ProgramaRepo extends CrudRepository<Programa, Long>{
	
	List<Programa> findAll();

}

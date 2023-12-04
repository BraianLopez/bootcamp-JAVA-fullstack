package com.codingdojo.cursosplataforma.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.cursosplataforma.models.Curso;

public interface CursoRepo extends CrudRepository<Curso, Long>{

	
	List<Curso> findAll();
}

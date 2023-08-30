package com.codingdojo.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.eventos.models.Eventos;
@Repository
public interface EventoRepo extends CrudRepository<Eventos, Long> {

	
	List<Eventos> findByProvincia(String provincia);
	
	
	List<Eventos> findByProvinciaIsNot(String provincia);

	List<Eventos> findAll();
	
}

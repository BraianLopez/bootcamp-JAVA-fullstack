package com.codingdojo.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lenguajes.models.Lenguajes;

public interface LenguajesRepo extends CrudRepository<Lenguajes, Long>{
	//ESTE METODO RECUPERA TODOS LOS LENGUAJES DE LA BASE DE DATOS
   List<Lenguajes> findAll();
   
   
}

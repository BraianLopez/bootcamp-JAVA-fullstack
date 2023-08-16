package com.codingdojo.licencias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.licencias.models.Licencia;

@Repository
public interface LicenciaRepo  extends CrudRepository<Licencia, Long>{

	
	
}

package com.codingdojo.waterbnb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.waterbnb.models.Water;

public interface WaterRepo extends CrudRepository<Water, Long>{

	
	List<Water> findAll();
	
	
	List<Water> findByDireccion(String location);
	
	
	@Query(value="SELECT AVG(rating) FROM comentarios WHERE water_id = :id", nativeQuery=true)
	Optional <Double> obtenerPromedioRatings(Long id);
}

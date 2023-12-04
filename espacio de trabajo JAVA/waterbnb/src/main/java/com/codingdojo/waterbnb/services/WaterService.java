package com.codingdojo.waterbnb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.waterbnb.models.Water;
import com.codingdojo.waterbnb.repositories.WaterRepo;

@Service
public class WaterService {

	private final WaterRepo waterRepo;
	public WaterService(WaterRepo wRe) {
		this.waterRepo = wRe;
	}
	public	Water createPool(Water pool) {
			return waterRepo.save(pool);
		}
	public List<Water> allPools(){
		return waterRepo.findAll();
	}
	
	public List<Water> piscinasLocacion(String location){
		return waterRepo.findByDireccion( location);
	}
	public	Water encontrarPorId(Long idPool) {
		return waterRepo.findById(idPool).orElse(null);
	}
	public Double obtenerPromedio(Long id) {
	return	waterRepo.obtenerPromedioRatings(id).orElse(null);
	}
	}


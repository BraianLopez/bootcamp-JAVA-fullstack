package com.codingdojo.dojosyninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosyninjas.models.DojoModel;
import com.codingdojo.dojosyninjas.models.NinjaModel;
import com.codingdojo.dojosyninjas.repositories.DojoRepo;
import com.codingdojo.dojosyninjas.repositories.NinjaRepo;

@Service
public class MainService {
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;

	public MainService(DojoRepo dojoR, NinjaRepo ninjaR) {
		this.dojoRepo = dojoR;
		this.ninjaRepo = ninjaR;
	}

	// METODOS DE CREACION
	public DojoModel crearDojo(DojoModel dojo) { // ESTE METODO CREA UN NUEVO DOJO
		return dojoRepo.save(dojo);
	}
	// METODOS DE CREACION
		public NinjaModel crearNinja(NinjaModel ninja) { // ESTE METODO CREA UN NUEVO DOJO
			return ninjaRepo.save(ninja);
		}
	// METODOS DE BUSQUEDA
	public List<DojoModel> todosDojos() {// BUSCA TODOS LOS DOJOS
		return dojoRepo.findAll();
	}

	public List<NinjaModel> todosNinjas() {// BUSCA TODOS LOS NINJAS
		return ninjaRepo.findAll();
	}
	
	public DojoModel unDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
		
	}
}

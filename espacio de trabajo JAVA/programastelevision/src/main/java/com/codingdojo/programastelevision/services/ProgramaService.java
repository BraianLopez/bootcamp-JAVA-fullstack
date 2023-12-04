package com.codingdojo.programastelevision.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.programastelevision.models.Programa;
import com.codingdojo.programastelevision.repositories.ProgramaRepo;

@Service
public class ProgramaService {
	// INYECCION DEPENDENCIAS
	private final ProgramaRepo progRepo;

	public ProgramaService(ProgramaRepo pRe) {
		this.progRepo = pRe;
	}

	public Programa crearPrograma(Programa programa) {
		return progRepo.save(programa);
	}

	public Programa editarPrograma(Programa programa) {
		return progRepo.save(programa);
	}

	public Programa unPrograma(Long id) {
		return progRepo.findById(id).orElse(null);
	}

	public List<Programa> todosProgramas() {
		return progRepo.findAll();
	}
	public void borrarPrograma(Long id) {
		progRepo.deleteById(id);
	}
}

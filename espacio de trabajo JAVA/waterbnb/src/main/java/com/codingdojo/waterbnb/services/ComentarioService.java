package com.codingdojo.waterbnb.services;

import org.springframework.stereotype.Service;

import com.codingdojo.waterbnb.models.Comentario;
import com.codingdojo.waterbnb.repositories.ComentarioRepo;

@Service
public class ComentarioService {
	
	private final ComentarioRepo comentRepo;
	public ComentarioService(ComentarioRepo cRe) {
		this.comentRepo = cRe;
	}
	public Comentario crearComentario(Comentario comentario) {
		return comentRepo.save(comentario);
	}
}

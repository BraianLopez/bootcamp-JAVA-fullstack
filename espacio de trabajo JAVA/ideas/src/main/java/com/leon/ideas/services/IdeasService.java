package com.leon.ideas.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.leon.ideas.models.IdeasModel;
import com.leon.ideas.repositories.IdeasRepo;


@Service
public class IdeasService {
	//INYECCION DE DEPENDENCIAS
	private final IdeasRepo ideasRepo;
	public IdeasService(IdeasRepo iRe) { //, MensajeRepo mRe
		this.ideasRepo = iRe; 
		//this.mensajeRepo = mRe;
	}

	// Crear Idea
		public IdeasModel crearIdea(IdeasModel idea) {
			return ideasRepo.save(idea);
		}

		// Editar Idea
		public IdeasModel actualizarEvento(IdeasModel idea) {
			return ideasRepo.save(idea); 
		}

		// Eliminar Idea
		public void borrarEvento(Long id) {
			ideasRepo.deleteById(id);
		}
		
		//Mostrar idea
		public List<IdeasModel> ideaUsuario(String idea){
			return ideasRepo.findAll(); 
		}
}

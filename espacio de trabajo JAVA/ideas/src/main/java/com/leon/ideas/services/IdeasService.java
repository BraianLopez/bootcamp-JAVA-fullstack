package com.leon.ideas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.leon.ideas.models.IdeasModel;
import com.leon.ideas.repositories.IdeasRepo;


@Service
public class IdeasService {
	//INYECCION DE DEPENDENCIAS
	private final IdeasRepo ideasRepo;
	public IdeasService(IdeasRepo iRe) {
		this.ideasRepo = iRe; 
		
	}

	// Crear Idea
		public IdeasModel crearIdea(IdeasModel idea) {
			return ideasRepo.save(idea);
		}
		//mostrar idea
		public IdeasModel encontrarIdeaPorId(Long id) {
			Optional<IdeasModel> idea = ideasRepo.findById(id);
			if (idea.isPresent()) {
				return idea.get();
			}
			return null;
		}

		// Editar Idea
		public IdeasModel actualizarIdea(IdeasModel idea) {
			return ideasRepo.save(idea); 
		}

		// Eliminar Idea
		public void borrarEvento(Long id) {
			ideasRepo.deleteById(id);
		}
		
		//Mostrar ideaS
		public List<IdeasModel> ideaUsuario(){
			return ideasRepo.findAll(); 
		}

		
}

package com.codingdojo.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lenguajes.models.Lenguajes;
import com.codingdojo.lenguajes.repositories.LenguajesRepo;


@Service
public class LenguajesService {
	 private  LenguajesRepo lenguajesRepo;
	    
	    public LenguajesService(LenguajesRepo lenguajesRepo) {
	        this.lenguajesRepo = lenguajesRepo;
	    }

	    //INTENTANDO CREAR UN LENGUAJE NUEVO
	    //AHORA YA LO CREA!!!!
	    public Lenguajes crearLenguajes(Lenguajes lenguaje) {
	    	return lenguajesRepo.save(lenguaje);
	    }
	    
	    //DEVOLVIENDO TODOS LOS LENGUAJES 
	    public List<Lenguajes> todosLenguajes() {
	        return lenguajesRepo.findAll();
	    }
	    
	    //OBTENIENDO LOS DETALLES DE UN LENGUAJE EN ESPECÍFICO
	    public Lenguajes findLanguage(Long id) {
	        Optional<Lenguajes> optionalLanguage = lenguajesRepo.findById(id);
	        if(optionalLanguage.isPresent()) {
	            return optionalLanguage.get();
	        } else {
	            return null;
	        }
	    }
	  //ACTUALIZAR INFORMACION
	    public Lenguajes actualizarLenguaje(Lenguajes language) {
	    	Lenguajes temporal = findLanguage(language.getId());
	    	temporal.setName(language.getName());
	    	temporal.setCreator(language.getCreator());
	    	temporal.setVersion(language.getVersion());
	    	
	    	return lenguajesRepo.save(temporal);
	    }
	    //SOBRECARGA DE METODO DE ACTUALIZAR INFORMACION
		public Lenguajes actualizarLenguaje(Long id,
				String name, 
				String creator, 
				String version) {
			Lenguajes temporal = lenguajesRepo.findById(id).orElse(null);
			if(temporal != null) {
				temporal.setName(name);
				temporal.setCreator(creator);
				temporal.setVersion(version);
				
				lenguajesRepo.save(temporal);
				return temporal;
			}else {
				return temporal;
			}
		}
	    //ELIMINA UN LENGUAJE
	    public void eliminarLenguaje(Long id) {
			 lenguajesRepo.deleteById(id);
		}
}

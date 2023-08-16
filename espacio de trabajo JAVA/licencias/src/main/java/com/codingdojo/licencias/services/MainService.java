package com.codingdojo.licencias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.licencias.models.Licencia;
import com.codingdojo.licencias.models.Persona;
import com.codingdojo.licencias.repositories.LicenciaRepo;
import com.codingdojo.licencias.repositories.PersonaRepo;


@Service
public class MainService {
	 
	
	@Autowired
	private  LicenciaRepo licenciaRepo;
	 
	@Autowired
	private  PersonaRepo personaRepo;
	   
	 
	    //METODO QUE CREA NUEVA PERSONA
	    public Persona crearPersona(Persona persona) {
	    	return personaRepo.save(persona);
	    }
	    
	    public List<Persona> todasPersonas(){
	    	return personaRepo.findAll();
	    }
	    
	    
	    public Licencia crearLicencia(Licencia licencia) {
	    	return licenciaRepo.save(licencia);
	    }
	    public List<Persona> personasSinLic(){
			return personaRepo.findNoLic();
		}
}

package com.codingdojo.licencias.services;

import java.util.List;
import java.util.Optional;

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
	    public  Persona buscarPersona(Long id) {
	      Optional<Persona> nuevaPersona = personaRepo.findById(id);
	    if (nuevaPersona.isPresent()) {
	    	return nuevaPersona.get();
	    }
	    return null;
	    }
	    
	    //METODO QUE CREA UNA NUEVA LICENCIA
	    public Licencia crearLicencia(Licencia licencia) {
	    	licencia.setNumber(this.generarNumerLic());
	    	return licenciaRepo.save(licencia);
	    }
	    public List<Persona> personasSinLic(){
			return personaRepo.findNoLic();
		}
	  //Metodo para generar numero de licencia
		public int generarNumerLic() {
			Licencia lic = licenciaRepo.findTopByOrderByNumberDesc();
			if(lic ==null) {
				return 1;
			}
			int numeroMayorLicencia = lic.getNumber();
			numeroMayorLicencia++;
			return numeroMayorLicencia;
			
		}

}

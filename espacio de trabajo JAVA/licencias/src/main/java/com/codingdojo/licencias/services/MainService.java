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
	
	// Inyeccion Dependencias
	@Autowired
	private LicenciaRepo licenciaRepo;
	
	@Autowired 
	private PersonaRepo personaRepo;
	
	
	//SERVICIOS PARA PERSONA
	public Persona crearPersona(Persona persona) {
		return personaRepo.save(persona);
	}
	
	public List<Persona> todasPersonas(){
		return personaRepo.findAll();
	}
	
	
	//SERVICIOS PARA LICENCIA
	public Licencia crearLicencia(Licencia licencia) {
		licencia.setNumber(this.generarNumerLic());
		return licenciaRepo.save(licencia);
	}
	
	public List<Persona> obtenerPersonasSinLic(){
		return personaRepo.findByLicenciaIdIsNull();
//		return personaRepo.encontrarNoLic();
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
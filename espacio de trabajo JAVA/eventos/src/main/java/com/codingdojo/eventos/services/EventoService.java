package com.codingdojo.eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.eventos.models.Eventos;
import com.codingdojo.eventos.repositories.EventoRepo;

@Service
public class EventoService {

	// INYECCION DEPENDENCIAS
		private final EventoRepo eventoRepo;

		public EventoService(EventoRepo eRe) {
			this.eventoRepo = eRe;
		}
		public Eventos crearEvento(Eventos evento) {
			return eventoRepo.save(evento);
		}
		public List<Eventos> eventoProvinciaUsuario(String provincia){
			return eventoRepo.findByProvincia(provincia);
		}
		public List<Eventos> eventoNoProvinciaUsuario(String provincia){
			return eventoRepo.findByProvinciaIsNot(provincia);
		}
		public Eventos unEvento(Long id) {
			return eventoRepo.findById(id).orElse(null);
		}
		public List<Eventos> todosEventos(){
			return eventoRepo.findAll();
		}
		public Eventos actualizarEvento(Eventos evento) {
			return eventoRepo.save(evento);
		}
		public void eliminarEvento(Long id) {
		 eventoRepo.deleteById(id);
		}
}

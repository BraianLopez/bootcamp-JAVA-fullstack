package com.codingdojo.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.eventos.models.Eventos;
import com.codingdojo.eventos.models.Provincias;
import com.codingdojo.eventos.models.User;
import com.codingdojo.eventos.services.EventoService;
import com.codingdojo.eventos.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EventoController {
	// INYECCION DEPENDENCIAS
	private final EventoService eventoService;
	private final UserServices userServ;

	public EventoController(EventoService eSer, UserServices uSer) {
		this.eventoService = eSer;
		this.userServ = uSer;

	}

	@PostMapping("/nuevo/evento")
	public String crearEvento(@Valid @ModelAttribute("evento") Eventos evento, BindingResult resultado,
			HttpSession sesion, Model viewModel) {
		// VALIDAR SI LA SESION ESTA ACTIVA
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}

		if (resultado.hasErrors()) {
			User usuario = userServ.encontrarPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("provincias", Provincias.provincias);
			viewModel.addAttribute("eventosProvinciaUser", eventoService.eventoProvinciaUsuario(usuario.getProvincia()));
			viewModel.addAttribute("eventosNoProvinciaUser", eventoService.eventoNoProvinciaUsuario(usuario.getProvincia()));
			return "/dashboard.jsp";
		}
		eventoService.crearEvento(evento);
		return "redirect:/events";
	}

	// EDITAR EVENTO
	@GetMapping("/events/{idEvento}/edit")
	public String formEditarEvento(@PathVariable("idEvento") Long idEvento, @ModelAttribute("evento") Eventos evento,
			HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		Eventos unEvento = eventoService.unEvento(idEvento);
		if (unEvento == null) {
			return "redirect:/events";
		}
		User usuario = userServ.encontrarPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("provincias", Provincias.provincias);
		viewModel.addAttribute("evento", unEvento);

		return "edit.jsp";
	}

	@PutMapping("/events/{id}/edit")
	public String editarEvento(@Valid @ModelAttribute("evento") Eventos evento, BindingResult resultado,
			@PathVariable("id") Long idEvento, HttpSession sesion, Model viewModel) {
		// VALIDAR SI LA SESION ESTA ACTIVA
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		User usuario = userServ.encontrarPorId(userId);
		if (resultado.hasErrors()) {
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("provincias", Provincias.provincias);
			return "edit.jsp";
		}
		eventoService.actualizarEvento(evento);
		return "redirect:/events";
	}

	@DeleteMapping("/events/{id}/delete")
	public String eliminarEvento(@PathVariable("id") Long idEvento) {
		eventoService.eliminarEvento(idEvento);
		return "redirect:/events";
	}

	// UNIRSE-CANCELAR ASISTENCIA
	@GetMapping("/events/{idEvento}/{idUsuario}/{opcion}")
	public String asistirCancelarEvento(@PathVariable("idEvento") Long idEvento,
			@PathVariable("idUsuario") Long idUsuario,
			@PathVariable("opcion") String opcion, HttpSession sesion) {
		//VALIDAR SI LA SESION ESTA ACTIVA
				Long userId = (Long) sesion.getAttribute("userID");
				if (userId == null) {
					return "redirect:/";
				}
				Eventos unEvento = eventoService.unEvento(idEvento); 	
				boolean unirseCancelar =(opcion.equals("unirse"));
				User usuario = userServ.encontrarPorId(userId);
				eventoService.unirseCancelarEvento(unEvento, usuario, unirseCancelar);
				return"redirect:/events";
	}
}

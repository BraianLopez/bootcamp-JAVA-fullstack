package com.leon.ideas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.leon.ideas.models.IdeasModel;
import com.leon.ideas.models.UserModel;
import com.leon.ideas.services.IdeasService;
import com.leon.ideas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class IdeasController {

	// INYECCION DE DEPENDENCIAS
	private final IdeasService ideasService;
	private final UserService userServ;

	public IdeasController(IdeasService iSer, UserService uSer) {
		this.ideasService = iSer;
		this.userServ = uSer;
	}

	@GetMapping("/nuevo/idea")
	public String crearIdea(Model viewModel, HttpSession sesion) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", userServ.encontrarUserPorId(userId));
		viewModel.addAttribute("ideas", new IdeasModel());
		return "crearideas.jsp";
	}

	@PostMapping("/nuevo/idea")
	public String crearIdea(@Valid @ModelAttribute("ideas") IdeasModel idea, BindingResult resultado,
			HttpSession sesion, Model viewModel) {

		// validar si la sesion del usuario esta activa
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		if (resultado.hasErrors()) {
			UserModel usuario = userServ.encontrarUserPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			return "crearideas.jsp";
		}
		ideasService.crearIdea(idea);
		return "redirect:/ideas";
	}

	@GetMapping("/ideas/{id}")
	public String mostrarIdea(@ModelAttribute("ideas") IdeasModel ideas, BindingResult resultado, HttpSession sesion,
			Model viewModel) {
		// validar la sesion del usuario
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		UserModel usuario = userServ.encontrarUserPorId(userId);
		IdeasModel unaIdea = ideasService.encontrarIdeaPorId(ideas.getId());
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("unaIdea", unaIdea);
		return "show.jsp";
	}

	@GetMapping("/ideas/{idIdea}/edit")
	public String editarIdea(@PathVariable("idIdea") Long idIdea, @ModelAttribute("ideas") IdeasModel ideas,
			BindingResult resultado, HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		IdeasModel unaIdea = ideasService.encontrarIdeaPorId(idIdea);
		if (unaIdea == null) {
			return "redirect:/ideas";
		}
		UserModel usuario = userServ.encontrarUserPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("idea", unaIdea);

		return "edit.jsp";
	}

	@PutMapping("/ideas/{id}/edit")
	public String editandoIdea(@Valid @ModelAttribute("ideas") IdeasModel idea, BindingResult resultado,
			@PathVariable("id") Long idIdea, HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		UserModel usuario = userServ.encontrarUserPorId(userId);
		if (resultado.hasErrors()) {
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("unaIdea", idea);
			viewModel.addAttribute("idIdea", idIdea);
			return "edit.jsp";
		}
		ideasService.actualizarIdea(idea);
		return "redirect:/ideas";
	}
	@GetMapping("/ideas/{idIdea}/{idUsuario}/{opcion}")
	public String likeDislike(@PathVariable("idIdea") Long idIdea,
			@PathVariable("idUsuario") Long idUsuario,
			@PathVariable("opcion") String opcion, HttpSession sesion) {
		//VALIDAR SI LA SESION ESTA ACTIVA
				Long userId = (Long) sesion.getAttribute("userID");
				if (userId == null) {
					return "redirect:/";
				}
				IdeasModel unaIdea = ideasService.encontrarIdeaPorId(idIdea); 	
				boolean likeDislike =(opcion.equals("like"));
				UserModel usuario = userServ.encontrarUserPorId(userId);
				ideasService.likeDislike(unaIdea, usuario, likeDislike);
				return"redirect:/ideas";
	}
	
	@GetMapping("/ideas/high")
	public String ordenarPorLikesAsc(Model viewModel, HttpSession sesion) {
		//VALIDAR SI LA SESION ESTA ACTIVA
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		UserModel usuario = userServ.encontrarUserPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		List<IdeasModel> ordenarPorMasLikes = ideasService.ordenarIdeasAsc();
		viewModel.addAttribute("likesHigh",ordenarPorMasLikes);
		return"highlikes.jsp";
	}
	@GetMapping("/ideas/low")
	public String ordenarPorLikesDesc(Model viewModel, HttpSession sesion) {
		//VALIDAR SI LA SESION ESTA ACTIVA
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		
		UserModel usuario = userServ.encontrarUserPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		List<IdeasModel> ordenarPorMenosLikes = ideasService.ordenarIdeasDesc();
		viewModel.addAttribute("likesLow",ordenarPorMenosLikes);
		return"lowlikes.jsp";
	}
	@GetMapping("/ideas/{id}/delete")
	public String eliminarIdea(@PathVariable("id") Long idIdea) {
		ideasService.borrarIdea(idIdea);
		return "redirect:/ideas";
	}
}

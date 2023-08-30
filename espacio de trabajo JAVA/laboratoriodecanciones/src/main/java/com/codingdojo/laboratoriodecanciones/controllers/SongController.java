package com.codingdojo.laboratoriodecanciones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.laboratoriodecanciones.models.Song;
import com.codingdojo.laboratoriodecanciones.models.User;
import com.codingdojo.laboratoriodecanciones.services.SongService;
import com.codingdojo.laboratoriodecanciones.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SongController {

	// INYECCION DEPENDENCIAS
	private SongService songServ;
	private UserServices userServ;

	public SongController(SongService sSer, UserServices uSer) {
		this.songServ = sSer;
		this.userServ = uSer;
	}

	@GetMapping("/songs/new")
	public String formCreateSong(@ModelAttribute("song") Song song, BindingResult resultado, HttpSession sesion,
			Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}

		User usuario = userServ.encontrarPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		return "newsong.jsp";
	}

	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult resultado, HttpSession sesion,
			Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}

		if (resultado.hasErrors()) {
			User usuario = userServ.encontrarPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			return "newsong.jsp";
		}
		songServ.createSong(song);
		return "redirect:/home";
	}

	@GetMapping("/songs/{idSong}")
	public String showSong(@PathVariable("idSong") Long idSong, @ModelAttribute("song") Song song,
			BindingResult resultado, HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		Song unaCancion = songServ.unaCancion(idSong);
		User usuario = userServ.encontrarPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("cancion", unaCancion);
		return "show.jsp";
	}

	@GetMapping("/songs/{idSong}/edit")
	public String formEditSong(@PathVariable("idSong") Long idSong, @ModelAttribute("songEdit") Song song,
			BindingResult resultado, HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		Song unaCancion = songServ.unaCancion(idSong);
		User usuario = userServ.encontrarPorId(userId);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("cancion", unaCancion);
		return "edit.jsp";
	}

	@PutMapping("/songs/{id}/edit")
	public String editSong(@Valid  @ModelAttribute("songEdit")Song song, BindingResult resultado,@PathVariable("id") Long idSong, 
			 HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		User usuario = userServ.encontrarPorId(userId);
		if (resultado.hasErrors()) {
			viewModel.addAttribute("usuario", usuario);
			return "edit.jsp";
		}
		songServ.editSong(song);
		return "redirect:/home";
	}

	@GetMapping("/songs/{id}/delete")
	public String deleteMapping(@PathVariable("id") Long idSong) {
		songServ.deleteSong(idSong);
		return "redirect:/home";
	}
}

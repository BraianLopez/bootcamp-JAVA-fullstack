package com.codingdojo.waterbnb.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.waterbnb.models.Comentario;
import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.models.Water;
import com.codingdojo.waterbnb.services.ComentarioService;
import com.codingdojo.waterbnb.services.UserServices;
import com.codingdojo.waterbnb.services.WaterService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PoolController {

	private final UserServices userServ;
	private final WaterService waterServ;
	private final ComentarioService comentServ;
	public PoolController(UserServices uSer, WaterService wSer,ComentarioService cSer) {
		this.userServ = uSer;
		this.waterServ = wSer;
		this.comentServ = cSer; 
	}

	@GetMapping("/")
	public String raiz() {
		return "index.jsp";
	}

	@GetMapping("/search")
	public String index(HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if (userLog == null) {
			return "redirect:/";
		}
		User usuario = userServ.encontrarPorId(userLog);
		viewModel.addAttribute("usuario", usuario);
		return "index.jsp";
	}
	//BUSCAR PISCINAS POR LOCACION
	@PostMapping("/search")
	public String search(@RequestParam(value = "location") String location, Model viewModel, HttpSession sesion,
			RedirectAttributes resultado) {
		Long userLog = (Long) sesion.getAttribute("userID");
		List<Water> eventosWater = waterServ.piscinasLocacion(location);
		if (userLog == null) {
			if (location.equals("")) {
				
				viewModel.addAttribute("pools", eventosWater);
				viewModel.addAttribute("usuario", userLog);
				return "searchForm.jsp";
			}
			return "redirect:/guest/signin";
		}
		viewModel.addAttribute("usuario", userLog);
		viewModel.addAttribute("pools", eventosWater);

		return "searchForm.jsp";
	}
	
	//MUESTRA PISCINAS DEL USUARIO Y FORMULARIO PARA CREAR UNA NUEVA
	@GetMapping("/host/dashboard")
	public String index(@ModelAttribute("newpool") Water pool, HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if (userLog == null) {
			return "redirect:/guest/signin";
		}
		User usuario = userServ.encontrarPorId(userLog);
		if (usuario.getRol().equals(2)) {
			return "redirect:/search";
		}
		viewModel.addAttribute("usuario", usuario);
		return "/host/dashboard.jsp";
	}

	@PostMapping("/new/pool")
	public String newPool(@Valid @ModelAttribute("newpool") Water pool, BindingResult resultado, HttpSession sesion,
			Model viewModel) {
		if (resultado.hasErrors()) {

			return "/host/dashboard.jsp";
		}
		waterServ.createPool(pool);
		return "redirect:/host/dashboard";
	}
	
	//MOSTRAR UNA PISCINA SEGUN SU ID
	@GetMapping("/pools/{idPool}")
	public String encontrarPool(@PathVariable("idPool")Long idPool,
			Model viewModel, HttpSession sesion) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if (userLog == null) {
			return "redirect:/guest/signin";
		}
		User usuario = userServ.encontrarPorId(userLog);
		Water unaPool = waterServ.encontrarPorId(idPool);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("pool", unaPool);
		
		return "showPool.jsp";
	}
	// RUTAS PARA AGREGAR COMENTARIO
		@GetMapping("/pools/{idPool}/review")
		public String formComentario(@PathVariable("idPool")Long idPool,
				Model viewModel, HttpSession sesion, @ModelAttribute("newcomment") Comentario newcomment ) {
			Long userLog = (Long) sesion.getAttribute("userID");
			if (userLog == null) {
				return "redirect:/guest/signin";
			}
			User usuario = userServ.encontrarPorId(userLog);
			Water unaPool = waterServ.encontrarPorId(idPool);
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("pool", unaPool);
			
			return "newReview.jsp";
		}
		@PostMapping("/pools/{id}/review")
		public String crearComentario(@Valid @ModelAttribute("newcomment") Comentario newcomment,BindingResult resultado,
				@PathVariable("id")Long idPool, HttpSession sesion, Model viewModel) {
			Long userLog = (Long) sesion.getAttribute("userID");
			User usuario = userServ.encontrarPorId(userLog);
			Water unaPool = waterServ.encontrarPorId(idPool);
			if (userLog == null) {
				return "redirect:/guest/signin";
			}
			
			if (resultado.hasErrors()) {
				viewModel.addAttribute("usuario", usuario);
				viewModel.addAttribute("pool", unaPool);
				
				return "newReview.jsp";
			}
			comentServ.crearComentario(newcomment);
			unaPool.setRating(waterServ.obtenerPromedio(idPool));
			return"redirect:/pools/"+idPool;
		}
}

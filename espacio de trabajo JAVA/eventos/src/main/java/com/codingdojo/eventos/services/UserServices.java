package com.codingdojo.eventos.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.eventos.models.User;
import com.codingdojo.eventos.repositories.UserRepo;

@Service
public class UserServices {

	// INYECCION DEPENDENCIAS
	private final UserRepo userRepo;

	public UserServices(UserRepo uRe) {
		this.userRepo = uRe;
	}

	// METODO DE BUSQUEDA POR EMAIL
	public User encontrarPorEmail(String email) {
		return userRepo.findByEmail(email);
	}

	// METODO DE BUSQUEDA POR EMAIL
	public User encontrarPorId(Long Id) {
		Optional<User> user = userRepo.findById(Id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	// METODO PARA EL REGISTRO DE UN NUEVO USUARIO
	public User registroUsuario(User user, BindingResult resultado) {
		User usuarioRegistrado = userRepo.findByEmail(user.getEmail());
		if (usuarioRegistrado != null) {
			resultado.rejectValue("email", "Matches", "el correo ingresado ya existe");
		}
		if (!user.getPassword().equals(user.getPasswordConfirmation())) {
			resultado.rejectValue("password", "Matches", "La clave debe coincidir en ambos campos");
		}
		if (resultado.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}

	// METODO DE AUTENTICACION DE USUARIO
	public boolean autenticarUsuario(String email, String password, BindingResult resultado) {

		User usuarioRegistrado = userRepo.findByEmail(email);
		if (usuarioRegistrado == null) {
			resultado.rejectValue("email", "Matches", "correo invalido");
			return false;
		} else if (BCrypt.checkpw(password, usuarioRegistrado.getPassword())) {
			return true;
		} else {
			resultado.rejectValue("password", "Matches",
					"la clave ingresada es incorrecta. Por favor, intente nuevamente");
			return false;
		}
	}

}

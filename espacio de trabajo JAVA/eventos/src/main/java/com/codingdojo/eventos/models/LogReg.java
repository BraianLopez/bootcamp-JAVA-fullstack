package com.codingdojo.eventos.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LogReg {
	@NotBlank(message = "ingrese una direccion de correo electronico")
	@Email(message = "el correo ingresado no es valido")
	private String email;
	@NotBlank( message = "ingrese una clave")
	@Size(min = 8, max = 64, message = "la clave debe tener minimo 8 caracteres")
	private String password;
	
	//CONSTRUCTOR
	public LogReg() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

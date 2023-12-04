package com.codingdojo.examenblackbelt.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "ingrese su nombre")
	private String nombre;
	@NotBlank(message = "ingrese una direccion de correo electronico")
	@Email(message = "el correo ingresado no es valido")
	private String email;
	
	@NotBlank( message = "ingrese una clave")
	@Size(min = 8, max = 64, message = "la clave debe tener minimo 8 caracteres")
	private String password;
	
	@Transient
	@NotBlank( message = "confirme su clave")
	private String passwordConfirmation;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	// Relacion 1:n hacia Courses
			@OneToMany(mappedBy = "creador", fetch = FetchType.LAZY)
			private List<Course> cursosCreados;
	// CONSTRUCTOR
	public User() {
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Course> getCursosCreados() {
		return cursosCreados;
	}

	public void setCursosCreados(List<Course> cursosCreados) {
		this.cursosCreados = cursosCreados;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}

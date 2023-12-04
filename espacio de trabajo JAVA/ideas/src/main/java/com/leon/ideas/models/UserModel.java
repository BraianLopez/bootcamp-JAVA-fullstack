package com.leon.ideas.models;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = " Por favor ingresa un nombre")
	@Size(min = 3, max = 30, message = "Nombre debe ser mayor a 3 caracteres y menor a 30")
	private String nombre;

	@NotBlank(message = " Por favor ingresa un correo electronico")
	@Email(message = "El correo ingresado no es correcto")
	private String email;

	@NotBlank(message = "Por favor, ingresa el password")
	@Size(min = 8, max = 64, message = "Password debe contener minimo 8 caracteres")
	private String password;

	@Transient
	@NotBlank(message = "Por favor confirma la contrasenia")
	@Size(min = 8, message = "Password debe contener minimo 8 caracteres")
	private String passwordConfirmation;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	// Relacion 1:n hacia Ideas
		@OneToMany(mappedBy = "creador", fetch = FetchType.LAZY)
		private List<IdeasModel> ideasCreadas;
		//RELACION MUCHOS A MUCHOS CON IDEAS
		@ManyToMany(fetch=FetchType.LAZY)
		@JoinTable(name="likes",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="idea_id"))
		private List<IdeasModel> likeIdea;
	
	//GETTERS Y SETTERS
	public UserModel() {
	}

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

	public List<IdeasModel> getIdeasCreadas() {
		return ideasCreadas;
	}

	public void setIdeasCreadas(List<IdeasModel> ideasCreadas) {
		this.ideasCreadas = ideasCreadas;
	}

	public List<IdeasModel> getLikeIdea() {
		return likeIdea;
	}

	public void setLikeIdea(List<IdeasModel> likeIdea) {
		this.likeIdea = likeIdea;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}

package com.codingdojo.programastelevision.models;

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

	@NotBlank(message = "ingresa un nombre")
	@Size(min = 3, max = 30, message = "minimo 3 caracteres ")
	private String nombre;

	@NotBlank(message = "  ingresa  correo electronico")
	@Email(message = " correo ingresado incorrecto")
	private String email;

	@NotBlank(message = " ingresa la clave")
	@Size(min = 8, max = 64, message = "clave debe tener minimo 8 caracteres")
	private String password;

	@Transient
	@NotBlank(message = "confirma la clave")
	@Size(min = 8, message = "clave debe contener minimo 8 caracteres")
	private String passwordConfirmation;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	public User() {
		
	}
	
	// Relacion 1:n hacia Ideas
		@OneToMany(mappedBy = "creador", fetch = FetchType.LAZY)
		private List<Programa> programas;
	
		

		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
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

		public List<Programa> getProgramas() {
			return programas;
		}

		public void setProgramas(List<Programa> programas) {
			this.programas = programas;
		}

		}

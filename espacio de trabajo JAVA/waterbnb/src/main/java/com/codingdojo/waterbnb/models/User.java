package com.codingdojo.waterbnb.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "ingrese su nombre")
	private String nombre;
	@NotBlank(message = "ingrese su apellido")
	private String apellido;
	@NotBlank(message = "ingrese una direccion de correo electronico")
	@Email(message = "el correo ingresado no es valido")
	private String email;

	@NotNull
	@Min(value=1,message="seleccione un rol")
	private Integer rol;
	@NotBlank( message = "ingrese una clave")
	@Size(min = 8, max = 64, message = "la clave debe tener minimo 8 caracteres")
	private String password;
	
	@Transient // NO CREA EL CAMPO AFECTADO EN LA TABLA "USERS".ESTO ES PORQUE NO QUEREMOS
				// GUARDAR EL VALOR DE "PASSWORDCONFIRMATION" EN LA BD
	@NotBlank( message = "confirme su clave")
	//@Size(min = 8, max = 64, message = "la clave debe tener minimo 8 caracteres")
	private String passwordConfirmation;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	// CONSTRUCTOR
	public User() {
		
	}
	
	//RELACION 1:n CON WATER
	@OneToMany(mappedBy="organizador", fetch=FetchType.LAZY)
	private List<Water> piscinas;
	
	// Relacion n:n hacia comentarios
		@OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<Comentario> comentarios;

	
	
	
	
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
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

	public List<Water> getPiscinas() {
		return piscinas;
	}

	public void setPiscinas(List<Water> piscinas) {
		this.piscinas = piscinas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	
}

package com.codingdojo.eventos.models;

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
	@NotBlank(message = "ingrese su nombre")
	private String nombre;
	@NotBlank(message = "ingrese su apellido")
	private String apellido;
	@NotBlank(message = "ingrese una direccion de correo electronico")
	@Email(message = "el correo ingresado no es valido")
	private String email;
	@NotBlank(message = "ingrese una ubicacion")
	private String ubicacion;
	@NotBlank(message = "Seleccione su provincia")
	private String provincia;
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
	
	//RELACION 1:n CON EVENTOS
	@OneToMany(mappedBy="organizador", fetch=FetchType.LAZY)
	private List<Eventos> EventosOrganizados;
	
	//RELACION MUCHOS A MUCHOS CON EVENTOS
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="asistentes",
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="evento_id"))
	private List<Eventos> eventoAsistir;
	
	
	
	
	
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Eventos> getEventosOrganizados() {
		return EventosOrganizados;
	}

	public void setEventosOrganizados(List<Eventos> eventosOrganizados) {
		EventosOrganizados = eventosOrganizados;
	}

	public List<Eventos> getEventoAsistir() {
		return eventoAsistir;
	}

	public void setEventoAsistir(List<Eventos> eventoAsistir) {
		this.eventoAsistir = eventoAsistir;
	}
	
}

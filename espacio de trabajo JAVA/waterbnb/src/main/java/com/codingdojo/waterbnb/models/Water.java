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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "piscinas")
public class Water {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="selecciona el tamaño de la piscina")
	private String poolsize;
	@Min(value=1, message="ingresa un costo por noche")
	private double costo;
	@DecimalMin("1.0")
	@DecimalMax("5.0")
	private Double rating = 5.0;
	@NotBlank(message="ingresa una descripcion sobre la piscina")
	private String descripcion;
	@NotBlank(message = "ingrese una direccion")
	@Size(min=3, message="minimo 3 caracteres")
	private String direccion;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	// RELACION n:1 A USUARIOS
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User organizador;
	
	// RELACION n:1 A COMENTARIOS
	@OneToMany(mappedBy = "piscina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comentario> comentarios;



	// CONSTRUCTOR
	public Water() {

	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getPoolsize() {
		return poolsize;
	}



	public void setPoolsize(String poolsize) {
		this.poolsize = poolsize;
	}



	public double getCosto() {
		return costo;
	}



	public void setCosto(double costo) {
		this.costo = costo;
	}



	public Double getRating() {
		return rating;
	}



	public void setRating(Double rating) {
		this.rating = rating;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
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



	public User getOrganizador() {
		return organizador;
	}



	public void setOrganizador(User organizador) {
		this.organizador = organizador;
	}



	public List<Comentario> getComentarios() {
		return comentarios;
	}



	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}



	@PrePersist
	protected void onCreate() { // ASIGNA EL ESPACIO DE TIEMPO EXACTO
		this.createdAt = new Date(); // EN EL QUE SE CREA UN LIBRO
	}

	@PreUpdate
	protected void onUpdate() { // ASIGNA EL ESPACIO DE TIEMPO EXACTO
		this.updatedAt = new Date(); // EN EL QUE SE ACTUALIZA UN LIBRO
	}
}

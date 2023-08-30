package com.codingdojo.eventos.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "eventos")
public class Eventos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "ingrese  nombre")
	@Size(min=3, message="minimo 3 caracteres")
	private String nombre;
	@Future(message = "ingrese una fecha posterior a hoy")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "ingrese la fecha del evento")
	private Date fecha;
	@NotBlank(message = "ingrese una ubicacion")
	private String ubicacion;
	@NotBlank(message = "Seleccione su provincia")
	private String provincia;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	// Relacion 1:n a usuarios
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User organizador;

	// CONSTRUCTOR
	public Eventos() {

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getOrganizador() {
		return organizador;
	}

	public void setOrganizador(User organizador) {
		this.organizador = organizador;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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

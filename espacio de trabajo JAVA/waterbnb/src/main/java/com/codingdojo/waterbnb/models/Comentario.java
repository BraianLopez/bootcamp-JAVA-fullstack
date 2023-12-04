package com.codingdojo.waterbnb.models;

import java.util.Date;

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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "comentarios")
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Min(value = 1, message = "selecciona el rating")
	private int rating;
	@NotBlank(message = "ingresa un comentario sobre la piscina")
	@Column(columnDefinition = "text")
	@Size(min = 3, message = "minimo 3 caracteres")
	private String comentario;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	// CONSTRUCTOR
	public Comentario() {

	}
	public Comentario(User usuario, Water piscina, String comentario) {
		this.autor = usuario;
		this.piscina = piscina;
		this.comentario = comentario;

	}
	// relaciones de tabla intermedia
	// RELACION n:1 A USUARIOS
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User autor;
	
// RELACION n:1 A WATER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "water_id")
	private Water piscina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	
	public User getAutor() {
		return autor;
	}
	public void setAutor(User autor) {
		this.autor = autor;
	}
	public Water getPiscina() {
		return piscina;
	}

	public void setPiscina(Water piscina) {
		this.piscina = piscina;
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
package com.codingdojo.cursosplataforma.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="cursos")
public class Curso {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = " Por favor ingresa el nombre del curso")
	@Size(min = 3, max = 30, message = "minimo 3 caracteres")
	private String curso;
	
	@NotBlank(message = " ingresa el instructor")
	@Size(min = 3, max = 30, message = "minimo 3 caracteres")
	private String instructor;
	
	@Min(value=1, message="ingresa la capacidad")
	private Integer capacidad;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	// RELACION 1:N hacia Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creador;

//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(name="likes",
//	joinColumns=@JoinColumn(name="idea_id"),
//	inverseJoinColumns=@JoinColumn(name="user_id"))
//	private List<UserModel> likes;
	
	public Curso() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
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

	public User getCreador() {
		return creador;
	}

	public void setCreador(User creador) {
		this.creador = creador;
	}
	
}

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "programas")
public class Programa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "ingresa titulo")
	@Size(min = 3, max = 30, message = "minimo 3 caracteres ")
	private String titulo;
	@NotBlank(message = "ingresa un canal ")
	@Size(min = 3, max = 30, message = "minimo 3 caracteres ")
	private String canal;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	public Programa() {
		
	}
	
	// Relacion n:1 hacia User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", updatable=false)
	private User creador;
	
	 
	
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

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getCanal() {
			return canal;
		}

		public void setCanal(String canal) {
			this.canal = canal;
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

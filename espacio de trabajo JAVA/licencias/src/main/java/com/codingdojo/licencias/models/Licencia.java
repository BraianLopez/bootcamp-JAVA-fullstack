package com.codingdojo.licencias.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="Licencias")

public class Licencia {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	// @NotBlank
	    private String number;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date expirationDate;
	 @NotBlank(message="Agrega un estado")
	    private String state;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @OneToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="persona_id")
	    private Persona persona;
	    @PrePersist
	    protected void onCreate(){			 //ASIGNA EL ESPACIO DE TIEMPO EXACTO  
	        this.createdAt = new Date();	 //EN EL QUE SE CREA UN LIBRO
	    }
	    @PreUpdate
	    protected void onUpdate(){			//ASIGNA EL ESPACIO DE TIEMPO EXACTO
	        this.updatedAt = new Date();	//EN EL QUE SE ACTUALIZA UN LIBRO
	    }
	 // Constructor
		public Licencia() {

		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public Date getExpirationDate() {
			return expirationDate;
		}
		public void setExpirationDate(Date expirationDate) {
			this.expirationDate = expirationDate;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
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
		public Persona getPersona() {
			return persona;
		}
		public void setPersona(Persona persona) {
			this.persona = persona;
		}
}

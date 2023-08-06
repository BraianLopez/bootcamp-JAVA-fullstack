package com.codingdojo.licencias.models;

import java.text.SimpleDateFormat;
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
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "licencia")
public class Licencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotBlank
	private Integer number;
	
	@Future(message="La fecha de expiracion deberia ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expirationDate;
	
	@NotBlank(message="Por favor agrega un estado de pais")
	private String state;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	private Persona persona;

	// Constructor
	public Licencia() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	public String getFechaExpiracionFormateada() {
		SimpleDateFormat fechaFormateada = new SimpleDateFormat("MM/dd/yyyy");
		return fechaFormateada.format(this.expirationDate);
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
	
	@PrePersist
	protected void createdAt() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}
	
	//metodo para retornar numero concatenado con 000
	public String getNumberComoString() {
		int numeroCeros = 5 - String.valueOf(this.number).length();
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<numeroCeros; i++) {
			stringBuilder.append('0');
		}
		return String.format("%s%d", stringBuilder, this.number);
	}
}
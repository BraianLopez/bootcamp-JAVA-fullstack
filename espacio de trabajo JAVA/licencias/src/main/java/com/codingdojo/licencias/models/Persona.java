package com.codingdojo.licencias.models;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="Personas")

public class Persona {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  @NotBlank
	    private String firstName;
	  @NotBlank
	  private String lastName;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @OneToOne(mappedBy="persona", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	    private Licencia licencia;
	    
	    @PrePersist
	    protected void onCreate(){			 //ASIGNA EL ESPACIO DE TIEMPO EXACTO  
	        this.createdAt = new Date();	 //EN EL QUE SE CREA UN LIBRO
	    }
	    @PreUpdate
	    protected void onUpdate(){			//ASIGNA EL ESPACIO DE TIEMPO EXACTO
	        this.updatedAt = new Date();	//EN EL QUE SE ACTUALIZA UN LIBRO
	    }
	 // Constructor
		public Persona() {

		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
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
		public Licencia getLicencia() {
			return licencia;
		}
		public void setLicencia(Licencia licencia) {
			this.licencia = licencia;
		}
}

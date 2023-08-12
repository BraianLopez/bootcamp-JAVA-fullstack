package com.codingdojo.lenguajes.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Lenguajes")
public class Lenguajes {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	 	@Size(min = 2, message="El nombre debe tener por lo menos 2 caracteres")
	    @Size( max = 20, message="El nombre debe tener hasta 20 caracteres")
	    private String name;
	 	
	 	@Size(min = 2, message="El nombre debe tener por lo menos 2 caracteres")
	    @Size( max = 20, message="El nombre debe tener hasta 20 caracteres")
	    private String creator;
	    
	    @NotBlank(message = "Por favor agrega una version")
		@Column(columnDefinition = "TEXT")
	    private String version;

	    
	    
	    @Column(updatable=false)//ESTO NO PERMITIRA QUE EL CAMPO createdAt SEA MODIFICADO DESPUES DE SU CREACION
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    public Lenguajes() {
	    	
	    }
	    public Lenguajes(String name, String creator,String version) {
	    	this.name = name;
	        this.creator = creator;
	        this.version = version;
	    }
	    
	    public Lenguajes(Long id, String name, String creator,String version) {
	        this.id= id;
	        this.name = name;
	        this.creator = creator;
	        this.version = version;
	    }
	    
	    
	    //GETTERS AND SETTERS
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
		@PrePersist
	    protected void onCreate(){			 //ASIGNA EL ESPACIO DE TIEMPO EXACTO  
	        this.createdAt = new Date();	 //EN EL QUE SE CREA UN LIBRO
	    }
	    @PreUpdate
	    protected void onUpdate(){			//ASIGNA EL ESPACIO DE TIEMPO EXACTO
	        this.updatedAt = new Date();	//EN EL QUE SE ACTUALIZA UN LIBRO
	    }
}

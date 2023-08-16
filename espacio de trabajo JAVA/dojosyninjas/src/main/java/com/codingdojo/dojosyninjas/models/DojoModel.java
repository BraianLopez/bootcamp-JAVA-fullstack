package com.codingdojo.dojosyninjas.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="dojos")
public class DojoModel {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  @NotBlank(message="Debes ingresar un nombre para el nuevo Dojo.")
	    private String name;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	    private List<NinjaModel> ninjas;
	    
	    
	    @PrePersist
	    protected void onCreate(){			 //ASIGNA EL ESPACIO DE TIEMPO EXACTO  
	        this.createdAt = new Date();	 //EN EL QUE SE CREA UN LIBRO
	    }
	    @PreUpdate
	    protected void onUpdate(){			//ASIGNA EL ESPACIO DE TIEMPO EXACTO
	        this.updatedAt = new Date();	//EN EL QUE SE ACTUALIZA UN LIBRO
	    }
	    public DojoModel() {
	        
	    }

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

		public List<NinjaModel> getNinjas() {
			return ninjas;
		}

		public void setNinjas(List<NinjaModel> ninjas) {
			this.ninjas = ninjas;
		}
}

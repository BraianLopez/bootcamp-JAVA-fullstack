package com.codingdojo.guardiadezoologicodos.clases;

public class Mamifero {
	private int nivelEnergia = 100;
	 private boolean estaDormido = false;
	 
	 
	 //CONSTUCTOR
	 
	 
	 	public int mostrarEnergia() {
	 		System.out.println("El nivel de energia es de "+ nivelEnergia);
	 		return nivelEnergia;
	 	}
	 	public Mamifero() {
	 		
	 	}
		public Mamifero(int nivelEnergia) {
			this.nivelEnergia= nivelEnergia;
		}
	 		
		 	
	    public Mamifero(int nivelEnergia, boolean estaDormido) {
		this.nivelEnergia = nivelEnergia;
		this.estaDormido = estaDormido;
	}
	
		public void regularTemperatura() {
	        System.out.println("Mi temperatura es la ideal justo ahora.");
	    }
	    public void empezarADormir() {
	        estaDormido = true;
	        System.out.println("ZzZz");
	    }
//	    //GETTERS AND SETTERS
	    public int getNivelEnergia() {
			return nivelEnergia;
		}
		public void setNivelEnergia(int nivelEnergia) {
			this.nivelEnergia = nivelEnergia;
		}
		public boolean isEstaDormido() {
			return estaDormido;
		}
		
		public void setEstaDormido(boolean estaDormido) {
			this.estaDormido = estaDormido;
		}
		
		public boolean estaDurmiendo(){
	        return estaDormido;
	    }
}

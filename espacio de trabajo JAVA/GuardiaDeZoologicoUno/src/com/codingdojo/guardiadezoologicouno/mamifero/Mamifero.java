package com.codingdojo.guardiadezoologicouno.mamifero;

public class Mamifero {
	protected int nivelEnergia = 100;
	 private boolean estaDormido = false;
	 
	 	public int mostrarEnergia() {
	 		System.out.println("El nivel de energia es de "+ nivelEnergia);
	 		return nivelEnergia;
	 	}
	    public void regularTemperatura() {
	        System.out.println("Mi temperatura es la ideal justo ahora.");
	    }
	    public void empezarADormir() {
	        estaDormido = true;
	        System.out.println("ZzZz");
	    }
//	    //GETTERS AND SETTERS
//	    public int getNivelEnergia() {
//			return nivelEnergia;
//		}
//		public void setNivelEnergia(int nivelEnergia) {
//			this.nivelEnergia = nivelEnergia;
//		}
//		public boolean isEstaDormido() {
//			return estaDormido;
//		}
//		public void setEstaDormido(boolean estaDormido) {
//			this.estaDormido = estaDormido;
//		}
//		public boolean estaDurmiendo(){
//	        return estaDormido;
//	    }
}

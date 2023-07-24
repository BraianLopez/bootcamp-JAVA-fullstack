package com.codingdojo.guardiadezoologicodos.clases;

public class Murcielago extends Mamifero {

	public Murcielago() {
		super(300);
		}	
	
	public void volar() {
		System.out.println("Sonido de despegue");
		this.setNivelEnergia(getNivelEnergia()-50);
	}
	public void comerHumano() {
		System.out.println("Bueno, no importa");
		this.setNivelEnergia(getNivelEnergia()+25);
	}
	public void atacarCiudad() {
		System.out.println("Sonido de ciudad en llamas");
		this.setNivelEnergia(getNivelEnergia()-100);
		
	}
}

package com.codingdojo.guardiadezoologicouno.mamiferos;

import com.codingdojo.guardiadezoologicouno.mamifero.Mamifero;

public class Gorila extends Mamifero {
	public void tirarAlgo() {
		System.out.println("el gorila ha arrojado un objeto");
	this.nivelEnergia -= 5;
	}
	public void comerBanana() {
		System.out.println("DELICIOSO!!");
	this.nivelEnergia += 10;
	}
	public void trepar() {
		System.out.println("el gorila ha trepado a la cima de un arbol");
	this.nivelEnergia -= 10;
	}
}

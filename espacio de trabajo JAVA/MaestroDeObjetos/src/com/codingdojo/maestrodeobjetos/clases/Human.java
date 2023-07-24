package com.codingdojo.maestrodeobjetos.clases;

public class Human {
private int fortaleza=3;
private int inteligencia=3;
private int sigilo=3;
private int vida=100;

//METODOS DE CLASE

public int  atacar(Human victima) {
	victima.vida-=this.fortaleza;
	System.out.println(victima.vida);
	return victima.vida;
}

//CONSTRUCTORES

public Human () {
	
}

}

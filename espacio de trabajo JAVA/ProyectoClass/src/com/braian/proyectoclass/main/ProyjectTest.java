package com.braian.proyectoclass.main;

import java.util.ArrayList;

import com.braian.proyectoclass.clases.Portafolio;
import com.braian.proyectoclass.clases.Project;

public class ProyjectTest {

	public static void main(String[] args) {
		Project Proyecto2 = new Project();
		Project Proyecto3 = new Project("marolio","le da sabor a tu vida",5.25);
		Project Proyecto1 = new Project("Cura Cocos","Cura Cocos acondiciona frascos para curar cannabis.",20.0);
        String proyectoA = Proyecto2.elevatorPitch();
        System.out.println(proyectoA);
        String proyectoB = Proyecto1.elevatorPitch();
        System.out.println(proyectoB);
        String proyectoC = Proyecto3.elevatorPitch();
        System.out.println(proyectoC);
         Portafolio portfolio1 = new Portafolio();
         portfolio1.addProject(Proyecto2);
         portfolio1.addProject(Proyecto1);
         portfolio1.addProject(Proyecto3);
         portfolio1.getPortfolioCost();
       
	}

}
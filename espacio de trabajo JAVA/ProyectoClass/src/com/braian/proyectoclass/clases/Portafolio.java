package com.braian.proyectoclass.clases;

import java.util.ArrayList;

public class Portafolio {
	private ArrayList<Project> proyectos = new ArrayList<Project>();
	//METODOS DE CLASE
	public void addProject(Project proyecto) {
		proyectos.add(proyecto);
	}
	
	
	public double getPortfolioCost() {
		double totalCost=0.0;
		for( Project proyecto  : this.proyectos) {
			totalCost += proyecto.getInitialCost();
		}

		System.out.println(totalCost);
		return totalCost;
	
	}
	

	//CONSTRUCTOR
	public void Portafolio() {
		
	}
	
	//GETTERS AND SETTERS
	public ArrayList<Project> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Project proyecto) {
		this.proyectos.add(proyecto);
	}
	
}
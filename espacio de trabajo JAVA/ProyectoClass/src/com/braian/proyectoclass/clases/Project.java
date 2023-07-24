package com.braian.proyectoclass.clases;


public class Project{
	private String name;
	private String description;
	private double initialCost;
	
	//METODO DE CLASE
	public String elevatorPitch(){
		if(this.name == null) {
			this.name = "Proyecto sin nombre";
		}
		if(this.description == null) {
			this.description = "No hay descripcion por el momento.";
		}
        return (this.name +"($"+ this.initialCost+")" + " : " + this.description);
    }
	//CONSTRUCTORES
	public Project() {
	//default constructor	
	}
	
	public Project(String name) {
	this.name = name;
	}
	
	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Project(String name, String description,double initialCost) {
		this.name = name;
		this.description = description;
		this.initialCost = initialCost;
	}
	
	
	//GETTERS & SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public  double getInitialCost() {
		return initialCost;
	}
	public void setInitialCost(double initialCost) {
		this.initialCost = initialCost;
	}
	
	
	
	//METODOS PROPIOS
	//public String greet(){
	//  return createGreeting("Mundo");
	//}
	
	//public String greet(String firstName, String lastName){
	//    return createGreeting(firstName + " " + lastName);
	//}
    
    //private String createGreeting(String toBeGreeted){
    //    return "Hola " + toBeGreeted;
    //}
}

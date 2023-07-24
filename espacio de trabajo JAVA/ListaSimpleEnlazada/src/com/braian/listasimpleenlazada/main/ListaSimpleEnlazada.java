package com.braian.listasimpleenlazada.main;
import java.util.ArrayList;


public class ListaSimpleEnlazada {
	
	private  ArrayList<Node> nodos = new ArrayList<Node>();
	public Node head;
	 
	 //CONSTRUCTOR
	    public ListaSimpleEnlazada() {

	    }
	    
		// METODOS DE CLASE
	    //COMO AGREGAR OBJETOS DE TIPO Node A NUESTRO ARRAYLIST "nodos".
	    public void add(int value) {
	        Node objeto = new Node(value);
	        nodos.add(objeto);
	        if(head == null) {
	            head = objeto;
	        } else {
	            Node runner = head;
	            while(runner.next != null) {
	                runner = runner.next;
	            }
	            runner.next = objeto;
	        }
	    }
	    //QUITAMOS EL ULTIMO NODO DE LA LISTA
	    public void remove() {
	    	while(nodos.size()>0) {
	    		this.nodos.remove(nodos.size()-1);
	    }
    		//System.out.println("Se elimino el ultimo nodo de la lista ") ;
	    }
	    //MUESTRA EL VALOR DE CADA NODO EN EL ORDEN EN QUE FUERON CREADOS
	    public void printValues() {
	    	for(Node objeto : this.nodos) {
	    		//System.out.println("agregando objeto");
	    		System.out.println(objeto.value);
	    	}
	    }
	    //MUESTRA EL INDICE DEL PRIMER NODO CON EL VALOR QUE RECIBE POR PARAMETRO
	    public void find(int valorNodo) {
	    	for(Node objeto : this.nodos) {
	    		if(objeto.value==valorNodo) {
	    		System.out.println("El primer nodo con valor 4 se encuentra en el indice "+ nodos.indexOf(objeto));
	    	}
	    	}
	    }
	    
}

package com.codingdojo.cuentadebanco.clases;
import java.util.Random;
public class CuentaDeBanco {
	
	//ATRIBUTOS
	private String numeroCuenta;
	private double saldoCuentaCorriente;
	private double saldoCuentaAhorro;
	private static int cuentasCreadas;
	
	
	//METODO DE CLASE
	
	private String crearNumeroCuenta() {
		Random numero = new Random();
		StringBuilder nuevoNumeroCuenta = new StringBuilder();
		for(int i = 0; i<10; i++) {
	        int rand_int1 = numero.nextInt(10);
	        nuevoNumeroCuenta.append(rand_int1);
		}
		this.numeroCuenta=nuevoNumeroCuenta.toString();
		return numeroCuenta;
	}
	
	//CONSTRUCTOR
	
	public CuentaDeBanco() {
		this.crearNumeroCuenta();
		this.cuentasCreadas++;
	}
	
	//METODOS PROPIOS
	
		public void depositarDineroEnCuentaCorriente(double cantidad) {
			this.saldoCuentaCorriente+=cantidad;
			System.out.println("Usted deposito en cuenta corriente $" + cantidad);
			System.out.println("Nuevo saldo en esta cuenta: $" + saldoCuentaCorriente); 
		}
		public void depositarDineroEnCuentaAhorro(double cantidad) {
			this.saldoCuentaAhorro+=cantidad;
			System.out.println("Usted deposito en esta cuenta $" + cantidad);
			System.out.println("Nuevo saldo en esta cuenta: $" + saldoCuentaAhorro); 
		}
		public void retirarDineroDeCuentaAhorro(double cantidad) {
			if(saldoCuentaAhorro>=cantidad) {
			this.saldoCuentaAhorro-=cantidad;
			System.out.println("retiro exitoso");
			System.out.println("Nuevo saldo en cuenta de ahorros: $" + saldoCuentaAhorro);
			}
			else {
				System.out.println("Saldo insuficiente, intente con una suma menor");
			}
		}
		public void retirarDineroDeCuentaCorriente(double cantidad) {
			if(saldoCuentaCorriente>=cantidad) {
			this.saldoCuentaCorriente-=cantidad;
			System.out.println("retiro exitoso");
			System.out.println("Nuevo saldo en cuenta corriente: $" + saldoCuentaAhorro);
			}
			else {
				System.out.println("Saldo insuficiente, intente con una suma menor");
			}
		}
		public double totalDinero() {
			double total =  saldoCuentaAhorro + saldoCuentaCorriente;
			System.out.println("el total de dinero en esta cuenta es: $" + total);
			return total;
		}
		
	//GETTERS
	
	public double getSaldoCuentaCorriente() {
		return saldoCuentaCorriente;
	}
	public double getSaldoCuentaAhorro() {
		return saldoCuentaAhorro;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
}
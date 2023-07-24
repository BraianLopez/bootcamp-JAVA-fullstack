package com.codingdojo.cuentadebanco.clases;

public class CuentaDeBancoTest {

	public static void main(String[] args) {
		CuentaDeBanco cuentaUno = new CuentaDeBanco();
		cuentaUno.depositarDineroEnCuentaAhorro(100);
		cuentaUno.totalDinero();
		cuentaUno.retirarDineroDeCuentaAhorro(200);
		cuentaUno.depositarDineroEnCuentaCorriente(500);
		cuentaUno.totalDinero();
		String nCuenta = cuentaUno.getNumeroCuenta();
		System.out.println(nCuenta);
	}
}

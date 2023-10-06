package main;

import java.util.ArrayList;

import clase.CuentaBancaria;
import clase.HiloCliente;

public class Main {

	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria();
		ArrayList<HiloCliente> clientes = new ArrayList<HiloCliente>();
		for (int i = 0; i < 25; i++) {
			HiloCliente hc = new HiloCliente(cuenta);
			clientes.add(hc);
			hc.start();
		}
		try {
			for (int i = 0; i < 25; i++) {
				clientes.get(i).join();
			}
		} catch (InterruptedException ex) {
			System.err.println(ex.getMessage());
		}
		System.out.println(cuenta.getSaldo());
		System.out.println(cuenta.getIngresos());
		System.out.println(cuenta.getResgitro());

	}

}

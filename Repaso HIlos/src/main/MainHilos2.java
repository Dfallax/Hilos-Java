package main;

import java.util.Scanner;

import hilos.Hilos2;

public class MainHilos2 {

	public static void main(String[] args) {

		// Haz un programa que pida al usuario una cadena y luego, con la ayuda de dos
		// hilos, muestre cuántos dígitos en total (0-9) tiene.
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un cadena ");
		String cadena = s.nextLine();

		int[] contadores = new int[2];

		Hilos2 h1 = new Hilos2(cadena.length()/2, cadena.length() , cadena, contadores, 0);
		Hilos2 h2 = new Hilos2(0, cadena.length()/2, cadena, contadores, 1);

		h1.start();
		h2.start();

		
		try {
			h1.join();
			h2.join();
			System.out.println("El numero total de digitos que tiene la cadena es :" + (contadores[0] + contadores[1]));

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package prexamenFinal;

import java.util.ArrayList;
import java.util.Scanner;

import prexamenFinal.Threads.ejercicio2;
import prexamenFinal.Threads.ejercicio2Registro;

public class ejercicio_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<ejercicio2> hilos = new ArrayList<ejercicio2>();
		final int NUM_HILOS = 3;
		final String PATH = "ejercicio2.";
		// TODO Auto-generated method stub
		/*
		 * Haz un programa que agilice la búsqueda de nombres dentro de 3 archivos. Para
		 * ello, pide el nombre a buscar y lanza 3 hilos que lo busquen de forma
		 * independiente en cada archivo. El contenido de los archivos debe ser nombres
		 * separados por comas: Alba,Juan,Pedro,Simón,Sara...
		 * 
		 */
		System.out.print("Escriba el nombre a buscar\n>");
		final String NAME = s.nextLine();
		ejercicio2Registro r = new ejercicio2Registro(NAME);

		for (int i = 0; i < NUM_HILOS; i++) {
			ejercicio2 h = new ejercicio2(PATH + (i+1) + ".txt", r);
			h.start();
			hilos.add(h);
		}

		for (ejercicio2 h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("las veces que se ha encontrado el nombre es: "+ r.getFoundName());
	}

}

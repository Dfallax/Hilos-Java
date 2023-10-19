package main;

import java.util.ArrayList;
import java.util.Scanner;

import hilos.Hilos3;

public class MainHilos3 {

	public static void main(String[] args) {

		/*
		 * Haz un programa que pida al usuario cuántos hilos (numHilos) quiere lanzar.
		 * Los hilos deben identificarse con su "name" tal que "H1", "H2", "H3"... Cada
		 * hilo genera un número aleatorio de 0 a 100 (ambos incluidos) y luego, cuando
		 * todos acaben, se muestra quién ha sido el que ha sacado el mayor y quién ha
		 * sido el que ha sacado el menor. Puede haber empates, en cuyo caso saldrán los
		 * nombres de varios.
		 */
		ArrayList<Hilos3> hilos = new ArrayList<Hilos3>();
		Scanner s = new Scanner(System.in);

		System.out.print("Ingresa la cantidad de hilos que quieras: ");
		final int cantidadHilos = s.nextInt();
		 int numMayor = 0;
		 int numMenor = 100;
		String HiloMayor="";
		String HiloMenor="";
		
		// CREAR LOS HILOS
		for (int i = 0; i < cantidadHilos; i++) {

			Hilos3 h = new Hilos3("H"+(i+1));
			

			hilos.add(h);
			h.start();

		}

		// esperamos los hilos
		for (Hilos3 h : hilos) {
			try {
				h.join();
				System.out.println(h.getName() + " SU NUMERO: " + h.getNum());

				if (h.getNum() < numMenor) {
					numMenor = h.getNum();
					HiloMenor = h.getName()  + " numero: " + h.getNum();
				}

				if (h.getNum() > numMayor) {
					numMayor = h.getNum();
					HiloMayor= h.getName() + " numero: " + h.getNum();
					
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("\n"+HiloMayor);
		System.out.println(HiloMenor);
		
	}

}

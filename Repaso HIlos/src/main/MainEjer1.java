package main;

import java.util.ArrayList;
import java.util.Scanner;

import hilos.EjrcHilo1;

public class MainEjer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, contadorCaras = 0, contadorCruces = 0;
		ArrayList<EjrcHilo1> hilos = new ArrayList<EjrcHilo1>();
		System.out.println("Introduce la cantidad de hilos: ");
		n=s.nextInt();
		
//Crear y lanzar los hilos
		for (int i = 0; i < n; i++) {
			EjrcHilo1 h = new EjrcHilo1();

			hilos.add(h);
			h.start();
		}
//Esperamos a todos
		for (EjrcHilo1 h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
// Recuento de caras y cruces
		for (EjrcHilo1 h : hilos) {
			if (h.isCara()) {
				contadorCaras++;
			} else {
				contadorCruces++;
			}
		}

		System.out.println("Han salido:  " + contadorCaras + " caras y " + contadorCruces + " cruces");
	}

}

package main;

import java.util.ArrayList;
import java.util.Scanner;

import hilos.Hilo5;
import hilos.Resultado;

public class MainHilo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Haz un programa que pida al usuario cuántos hilos (numHilos) quiere lanzar.
		 * El número de hilos debe ser par, ya que se van a dividir en dos equipos: yin
		 * y yang. Todos ellos tienen una balanza común, un número que empieza en cero.
		 * A continuación, cada uno genera un número aleatorio del 1 al 10. Los hilos
		 * del yin van a restar sus números generados de la balanza, mientras que los
		 * del yang van a sumarlos. Al final, el programa mostrará qué equipo ha ganado:
		 * si sale negativo, yin; si sale positivo, yang. Puede ocurrir un estado de
		 * equilibrio perfecto si la balanza permanece en 0.
		 */

		Scanner s = new Scanner(System.in);
		ArrayList<Hilo5> hilos = new ArrayList<Hilo5>();
		System.out.print("Intruduzca la cantidad de hilos: ");
		int numHilos = s.nextInt();
		int signo = 1;
		Resultado balanza = new Resultado();

		for (int i = 0; i < numHilos; i++) {
			signo = signo * -1;
			Hilo5 h = new Hilo5(balanza, signo);

			hilos.add(h);
			h.start();

		}

		for (Hilo5 h : hilos) {

			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if (balanza.getBalanza() > 0) {
			System.out.println("Gano es el YAN resultado: " + balanza.getBalanza());
		} else if (balanza.getBalanza() < 0) {
			System.out.println("Gano el YIN resultado: " + balanza.getBalanza());
		} else {
			System.out.println("hubo un equilibrio: " + balanza.getBalanza());
		}
	}

}

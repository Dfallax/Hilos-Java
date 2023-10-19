package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import hilos.Hilos4;
import hilos.Marcador;

public class MainHilo4 {

	
	//	Haz un programa que pida al usuario cuántos hilos (numHilos) quiere lanzar
	//. Los hilos realizarán una carrera. Cada hilo espera un tiempo aleatorio entre 10 y 25 milisegundos y a continuación
	//	van a poner su nombre en la lista de llegada a la meta. Al final, el hilo principal muestra dicha lista.
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce la cantidad de hilos: ");
		ArrayList<Hilos4> hilos = new ArrayList<Hilos4>();
		Marcador marcador = new Marcador();
     	int numHilos=s.nextInt();
     	
	
     	for(int i = 0; i < numHilos; i++) {
		
		Hilos4 h = new Hilos4(marcador);
		h.setNombre("Hilo N: " + (i+1));
		
		hilos.add(h);
		h.start();
		
	}
		System.out.println("\t LISTA DE LLEGADA");
		System.out.println("-------------------------------------");

		
		
		try {	
			for (int i = 0; i < hilos.size(); i++) {
				

				hilos.get(i).join();
				System.out.println((i+1)+").  "+marcador.getName().get(i));	
			}
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	
		
		
	System.out.println("------------------------------------------");
		
	}

}

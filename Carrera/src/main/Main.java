package main;

import java.util.ArrayList;
import clase.Hilo;
import clase.Marcador;


public class Main {

	public static void main(String[] args) {

		
		/*
		 * Se debe simular una carrera de coches en un circuito cerrado.
La carrera constará de N pilotos, cada uno con su identificador asignado,
siendo N una cantidad definida en una variable (no hace falta pedir al usuario este valor, lo pondremos desde código).
Los N pilotos serán hilos independientes, y tienen que hacer un total de 10 vueltas.
En completar cada vuelta tardan un tiempo aleatorio de 0.5 a 3 segundos.
El hilo principal, una vez han salido los coches, va mostrando cada segundo cómo está actualmente el orden desde el primero 
(el que toma la delantera) hasta el décimo (el que va último), indicando el identificador, 
las vueltas que lleva y la posición de los participantes.
Ejemplo de mensaje que proyectaría el main en un segundo aleatorio dentro de toda la carrera:
		
NOTA: para la calificación se tendrán en cuenta, además del correcto funcionamiento de la aplicación acorde con lo que se pide,
la eficiencia y buenas prácticas de programación que se esperan de cualquier programa de calidad.
		*/
				
		ArrayList<Hilo> pilotos = new ArrayList<Hilo>();
		Marcador marcador = new Marcador();
     	int N=10;
     	
	
     	for(int i = 0; i < N; i++) {
		
		Hilo p = new Hilo();
		
		pilotos.add(p);
		p.start();
		
	}
		System.out.println("Coche Vuelta Posicion");
		System.out.println("----------------------");

		
		
		try {	
			for (int i = 0; i < pilotos.size(); i++) {
				

				pilotos.get(i).join();
				System.out.printf("%18s",marcador.getNombre());	
			}
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
			
	     System.out.println("-------------------------");
		
	}
		
	

}

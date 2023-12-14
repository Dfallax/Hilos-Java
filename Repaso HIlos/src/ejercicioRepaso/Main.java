package ejercicioRepaso;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int numero;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		Consumidor c;
		Lista l = new Lista();
		ArrayList<Consumidor> hilos = new  ArrayList<>();
		//Registro r = new Registro();
	
		Productor p = new Productor(l);

		System.out.print("ingresa el numero a buscar\n>");
		numero = s.nextInt();
        System.out.print("Cuantos hilos quieres lanzar?\n>");
        final int MAX_H = s.nextInt();
        
        
        for(int i = 0; i < MAX_H; i++) {
        	
        	 c = new Consumidor(l);
        	 c.start();
        	 hilos.add(c);
        }
		
 		p.start();

		try {
			p.join();
			
			for(Consumidor co : hilos ) {
				co.join();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("El numero total de veces que se ha encontrado el numero es: " + l.getContador());

	}

}

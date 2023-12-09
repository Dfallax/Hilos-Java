package prexamenFinal;

import prexamenFinal.Threads.Hilo1;
import prexamenFinal.Threads.Hilo2;
import prexamenFinal.Threads.Lista;

public class main {
	
	public static void main(String[] args) {
	       /*  Ejercicio 1
	        Haz un programa que lea los caracteres de un archivo y nos diga cuántos dígitos tiene.
	        Para ello, un hilo lee los caracteres uno a uno y los añade a una lista. Mientras, otro hilo los va quitando de la lista y los evalúa para saber si son dígitos.
	        Al final, se muestra el total de dígitos contados.*/
	        Lista l = new Lista();
	        Hilo1 h1 = new Hilo1(l);
	        Hilo2 h2 = new Hilo2(l);
	      
	        h1.start();
	        h2.start();

	        try {
	            h1.join();
	            h2.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	     System.out.println("el numero total de digitos son: " + h2.getContador());

	   }
}

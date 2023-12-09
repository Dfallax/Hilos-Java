package ejercicio3;

import java.util.ArrayList;

public class Lista {

	private ArrayList<Integer> numeros;
	private static final int CAPACIDAD = 1;
	public static boolean repartidorFinish; 
	
	public synchronized void agregar(int numero) {

		while (numeros.size() == CAPACIDAD) {

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		numeros.add(numero);
		System.out.println("add");
		notifyAll();
	}
	
	
	public synchronized int extraer() {

		while (numeros.isEmpty()) {
System.out.println("enceradooooo");
			try {
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		notifyAll();
		System.out.println("remove");
		return numeros.remove(0);
	}
	
	
	
	
	public Lista() {
		numeros = new ArrayList<Integer>();
		
	}
	

	public ArrayList<Integer> getNumeros() {
		return numeros;
	}
	public void setNumeros(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}
	public static boolean isRepartidorFinish() {
		return repartidorFinish;
	}
	public static void setRepartidorFinish(boolean repartidorFinish) {
		Lista.repartidorFinish = repartidorFinish;
	}
	public static int getCapacidad() {
		return CAPACIDAD;
	}
	
}
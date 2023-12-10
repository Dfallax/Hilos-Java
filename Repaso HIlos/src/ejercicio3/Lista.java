package ejercicio3;

import java.util.ArrayList;

public class Lista {

	private ArrayList<Integer> numeros;
	private static final int CAPACIDAD = 2;
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
		System.out.println("quitar");
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

package ejercicioRepaso;

import java.util.ArrayList;

public class Lista {

	private ArrayList<String> numeros;
	private final int CAPACIDAD = 10;
	public int contadorFinish;
	private int contador;

	public synchronized void agregar(String numero) {

		
		numeros.add(numero);
		System.out.println("add");
		notifyAll();
	}

	public synchronized String extraer() {

		while (numeros.isEmpty() && contadorFinish != Main.numArchivos) {
			System.out.println("encerrado");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		notifyAll();
		if (numeros.isEmpty()) {
			return null;
		} else {
			return numeros.remove(0);

		}

	}

	public synchronized void setContadorFinish(int contadorFinish) {
		this.contadorFinish += contadorFinish;
		notifyAll();
	}

	public synchronized void numEnontrado(int numero) {

		this.contador += numero;

	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Lista() {

		numeros = new ArrayList<>();

	}

	public ArrayList<String> getNumeros() {
		return numeros;
	}

	public void setNumeros(ArrayList<String> numeros) {
		this.numeros = numeros;
	}

	public int getContadorFinish() {
		return contadorFinish;
	}

	public int getCAPACIDAD() {
		return CAPACIDAD;
	}

}

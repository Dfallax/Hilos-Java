package postExamen;

import java.util.ArrayList;

public class Lista {

	private ArrayList<String> cadenas;
	private final int CAPACIDAD = 2;
	public static boolean productorFinish;

	public synchronized void agregar(String cadena) {

		while (cadenas.size() == CAPACIDAD) {

			try {
				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		cadenas.add(cadena);
		notifyAll();

	}

	public synchronized String extraer() {

		return cadenas.remove(0);

	}

	public ArrayList<String> getCadenas() {
		return cadenas;
	}

	public void setCadenas(ArrayList<String> cadenas) {
		this.cadenas = cadenas;
	}

	public static boolean isProductorFinish() {
		return productorFinish;
	}

	public static void setProductorFinish(boolean productorFinish) {
		Lista.productorFinish = productorFinish;
	}

	public int getCAPACIDAD() {
		return CAPACIDAD;
	}

	public Lista() {
		cadenas = new  ArrayList<>();
	}
}

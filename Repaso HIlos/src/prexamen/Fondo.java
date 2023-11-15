package prexamen;

import java.util.ArrayList;
import java.util.Collections;

public class Fondo {

	private float fondo;
	public static ArrayList<Integer> ingresos = new ArrayList<Integer>();

	public synchronized void fondoTotal(int dinero) {

		this.fondo += dinero;
		ingresos.add(dinero);

		for (int i = 0; i < ingresos.size(); i++) {

			if (dinero < ingresos.get(i)) {
				Collections.swap(ingresos, i, ingresos.size() - 1);
			}

		}

	}

	public Fondo() {

	}

	public Fondo(float fondo) {
		this.fondo = fondo;
	}

	public float getFondo() {
		return fondo;
	}

	public void setFondo(float fondo) {
		this.fondo = fondo;
	}

}

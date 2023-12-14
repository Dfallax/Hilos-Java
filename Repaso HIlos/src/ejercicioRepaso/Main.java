package ejercicioRepaso;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int numero;
	public static int numArchivos;
	static ArrayList<String> nombresArchivos = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		Consumidor c;
		Productor p;
		Lista l = new Lista();
		ArrayList<Consumidor> hilos = new ArrayList<>();
		ArrayList<Productor> hilosP = new ArrayList<>();
		nomrbresArchivos();
		
		if (!nombresArchivos.isEmpty()) {
			numArchivos = nombresArchivos.size();
			
			System.out.print("ingresa el numero a buscar\n>");
			numero = s.nextInt();
			System.out.print("Cuantos hilos quieres lanzar?\n>");
			final int MAX_H = s.nextInt();

			for (int i = 0; i < MAX_H; i++) {

				c = new Consumidor(l);
				c.start();
				hilos.add(c);

			}

			for (int i = 0; i < numArchivos; i++) {
				p = new Productor(l, nombresArchivos.get(i));
				p.start();
				hilosP.add(p);
			}

			try {

				for (Productor pr : hilosP) {
					pr.join();
				}
				for (Consumidor co : hilos) {
					co.join();
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("El numero total de veces que se ha encontrado el numero es: " + l.getContador());

		}
	}

	public static void nomrbresArchivos() {
		final String PATH_D = ".";
		File f = new File(PATH_D);
		String[] nombres = f.list();

		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].contains("numeros")) {
				nombresArchivos.add(nombres[i]);
			}
		}

	}

}

package ejercicioRepaso;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int numero;
	public static int numArchivos;
	static ArrayList<String> nombresArchivos = new ArrayList<>();

	public static void main(String[] args) {
				Scanner s = new Scanner(System.in);
		Consumidor c;
		Productor p;
		Lista l = new Lista();
		ArrayList<Consumidor> hilos = new ArrayList<>();
		ArrayList<Productor> hilosP = new ArrayList<>();
		System.out.print("Escriba la ruta de la carpeta\n>");
		final String PATH_D = s.nextLine();
		nomrbresArchivos(PATH_D);

		if (!nombresArchivos.isEmpty()) {
			numArchivos = nombresArchivos.size();

			System.out.print("ingresa el numero a buscar\n>");
			numero = s.nextInt();
			System.out.print("Cuantos hilos quieres lanzar?\n>");
			final int MAX_H = s.nextInt();
			
			long startTime = System.currentTimeMillis();
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
				
				e.printStackTrace();
			}

			System.out.println("El numero total de veces que se ha encontrado el numero es: " + l.getContador());
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;

			System.out.println("Tiempo transcurrido en milisegundos: " + totalTime);

		}
	}

	public static void nomrbresArchivos(String path) {

		File f = new File(path);
		String[] nombres = f.list();

		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].contains("rand")) {
				nombresArchivos.add(path+"\\"+nombres[i]);
			}
		}

	}

}

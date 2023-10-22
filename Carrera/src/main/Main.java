package main;

import java.util.ArrayList;
import clase.Piloto;
import clase.Marcador;

public class Main {
	static final int N = 10;
	static ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
	static Marcador marcador = new Marcador();

	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {

			Piloto p = new Piloto(marcador);
			p.setNombre("C" + (i + 1));

			pilotos.add(p);
			p.start();

		}
		
		System.out.println("Coche Vuelta Posicion");
		System.out.println("----------------------");

		for (int i = 0; i < 20; i++) {

			try {
				pilotos.get(i).join();
				Thread.sleep(1000);
					System.out.println(pilotos.get(i).getNombre() +"       "+pilotos.get(i).getMarcador().getMarcador());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
		System.out.println("-------------------------");
		
}
	}

		

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
			marcador.setPilotos(p.getNombre());
			marcador.setVueltas(p.getVuelta());
			pilotos.add(p);
			p.start();

		}

		do {
			System.out.println("Coche Vuelta Posicion");
			System.out.println("----------------------");

			try {
				Thread.sleep(1000);

				for (int i = 0; i < marcador.getPilotos().size(); i++) {

					System.out.println(marcador.getPilotos().get(i) + "    " + marcador.getVueltas().get(i) + "    ("
							+ (i + 1) + ")");

				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("-------------------------\n\n");
		} while (marcador.getVueltas().get(N-1)!=10);

	}

}

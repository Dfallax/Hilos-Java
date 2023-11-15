package prexamen;

import java.util.ArrayList;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int NUM_HILOS=10;
		Fondo fondo = new Fondo();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		for(int i = 0; i < NUM_HILOS; i++) {
			
			Usuario h = new Usuario(fondo);
			usuarios.add(h);
			h.start();
		}
		
		
		for(int i = 0; i < usuarios.size(); i++ ) {
			try {
				usuarios.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("fondo total: "+fondo.getFondo());
		System.out.print("Trazas: ");
		for(int i = 0; i < fondo.ingresos.size(); i++) {
			
			if(i==fondo.ingresos.size()-1) {
				System.out.println(fondo.ingresos.get(i));
			}else {
				System.out.print(fondo.ingresos.get(i)+"+");
			}
			
		}
		
	}

}

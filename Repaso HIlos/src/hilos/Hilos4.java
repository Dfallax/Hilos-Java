package hilos;

import java.util.Random;

public class Hilos4 extends Thread {

	private String nombre;
	private Marcador posicion;
	
	public Hilos4(Marcador posicion) {
		
		this.posicion=posicion;
	}
	
	public void run() {
		
		try {
			
			Thread.sleep(new Random().nextInt(10,26));
			posicion.Carrera(nombre);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

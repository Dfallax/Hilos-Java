package clase;

import java.util.Random;

public class Hilo extends Thread {
 
	private Marcador vuelta;
	private String nombre;
	private int Vuelta;
	//En completar cada vuelta tardan un tiempo aleatorio de 0.5 a 3 segundos.
	
	public Hilo() {
		
	}
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(3000,40000));
			this.Vuelta++;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
						
	
	}
	
	public void setVuelta(Marcador vuelta) {
		this.vuelta = vuelta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setVuelta(int vuelta) {
		Vuelta = vuelta;
	}
	
	
}

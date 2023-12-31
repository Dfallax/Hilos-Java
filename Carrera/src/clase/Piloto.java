package clase;

import java.util.Random;

public class Piloto extends Thread {
    
	private final int MAX_VUELTAS=10;
	private Marcador marcador;
	private String nombre;
	private int vuelta;
	
	//En completar cada vuelta tardan un tiempo aleatorio de 0.5 a 3 segundos.
	

	
	public Piloto(Marcador marcador) {
		
		this.marcador=marcador;
	}
	
	public Piloto(String nombre, int vuelta) {
		this.nombre = nombre;
		this.vuelta = vuelta;
	}
	
	public void run() {
		
		
			
			try {
				
				while(this.vuelta!=MAX_VUELTAS) {
				Thread.sleep(new Random().nextInt(300,3001));
				this.vuelta++;
				marcador.actualizarMarcador(nombre,vuelta);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		
						
	
	}
	
	
	public Marcador getMarcador() {
		return marcador;
	}
	public void setMarcador(Marcador marcador) {
		this.marcador = marcador;
	}
	public int getVuelta() {
		return vuelta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVuelta(int vuelta) {
		this.vuelta = vuelta;
	}

	public int getMAX_VUELTAS() {
		return MAX_VUELTAS;
	}
	
	
	
}

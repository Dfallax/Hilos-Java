package clase;

import java.util.ArrayList;

public class Marcador {

	private ArrayList<String> marcador = new ArrayList<String>();
	private int posicion;
	
	public Marcador() {
		
	}
	public synchronized void actualizarMarcador(int vuelta) {
		marcador.add("jolll");
			
		
	}
	public ArrayList<String> getMarcador() {
		return marcador;
	}

	public void setMarcador(ArrayList<String> marcador) {
		this.marcador = marcador;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	
	
}

package clase;

import java.util.ArrayList;
import java.util.Collections;

public class Marcador {

	private ArrayList<String> pilotos = new ArrayList<String>();
    private ArrayList<Integer> vueltas = new ArrayList<Integer>();
	
    
    public Marcador() {
		
	}
    

	public  void actualizarMarcador(String nombre, int vuelta) {
	
	for(int posNmb = 0; posNmb < pilotos.size();posNmb++ ) {
		
		if(pilotos.get(posNmb).equals(nombre)) {
			
			for(int posVuelta = 0; posVuelta < vueltas.size();posVuelta++) {
				
				if(vuelta>vueltas.get(posVuelta)) {
					vueltas.set(posNmb,vuelta);
					Collections.swap(pilotos, posNmb, posVuelta);
					Collections.swap(vueltas, posNmb, posVuelta);
					
					posNmb=pilotos.size();
					break;	
			   }
				
			}
		}
	
	}
						
	}
	
	public void listaPilotos(ArrayList<String> pilotos) {
		this.pilotos=pilotos;
	}
	
	public ArrayList<String> getPilotos() {
		return pilotos;
	}
	public void setPilotos(String pilotos) {
		this.pilotos.add(pilotos);
	}
	public ArrayList<Integer> getVueltas() {
		return vueltas;
	}
	public void setVueltas(int vueltas) {
		this.vueltas.add(vueltas);
	}
	
	
	
}

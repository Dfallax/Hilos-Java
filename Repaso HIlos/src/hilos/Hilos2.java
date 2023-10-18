package hilos;

public class Hilos2 extends Thread {

	private String cadena;
	private final int i0;
	private final int f0;
private	int []contador;
	private int posicion;


	public Hilos2(int i0, int f0, String cadena,int contador[],int posicion) {
		this.cadena = cadena;
		this.i0 = i0;
		this.f0 = f0;
		this.posicion=posicion;
		this.contador=contador;
	}

	
	public void run() {
	
		for (int i = i0; i < f0; i++) {

			if (cadena.charAt(i) >= '0' && cadena.charAt(i) <= '9') {
				contador[posicion]++;
			} 
			
		}
		

	}
}

package ejercicioRepaso;

public class Registro {
	
	private int contador;
	
	public synchronized void numEnontrado(int numero) {
		
		this.contador += numero; 
		
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	public Registro() {
		
	}

}

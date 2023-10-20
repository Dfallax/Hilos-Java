package hilos;

public class Resultado {

	private int balanza;
	
	public Resultado(){
		
	}
	
	public synchronized void start(int num) {
		balanza += num;
		
	}

	public int getBalanza() {
		return balanza;
	}

	public void setBalanza(int balanza) {
		this.balanza = balanza;
	}
	
}

package prexamenFinal.Threads;

public class ejercicio2Registro {

	private String name;
	private int foundName;

	public synchronized void search(String cadena) {

		if(name.equals(cadena)) {
			foundName++;
		}
		
	}

	public ejercicio2Registro(String name) {
		
		this.name = name;
	}

	public int getFoundName() {
		return foundName;
	}

	public void setFoundName(int foundName) {
		this.foundName = foundName;
	}

	
}

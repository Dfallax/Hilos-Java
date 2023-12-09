package ejercicio3;

public class Receptor extends Thread {

	private Lista lista;
	private int numMax;
	
	public void run() {
		
		do {
			
			while (!lista.getNumeros().isEmpty()) {
				//System.out.println(Lista.repartidorFinish);
				numMax = Math.max(lista.extraer(), numMax);				
			}

		}while(!Lista.repartidorFinish);
		System.out.println("ACABDOO");

	}

	public Receptor(Lista lista) {
		super();
		this.lista = lista;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public int getNumMax() {
		return numMax;
	}

	public void setNumMax(int numMax) {
		this.numMax = numMax;
	}

}

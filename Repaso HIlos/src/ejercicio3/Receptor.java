package ejercicio3;

public class Receptor extends Thread {

	private Lista lista;
	private int numMax;

	
	/*
	 * Cambiar el el boolean y hacer un tipo for en donde se buscara un limite que se irá atcualizando
	 * a medida que va agregando el numero y a la vez no rompa el bucle hasta que termine el repartidor
	 * BUSCAR OTRA MANERA DE TERMINA EL BUCLEL==>boolean
	 * meter el limite desde la lista compartida
	 * 
	 * usar wait para esperar para que llegue el boolean*/
	
	public void run() {

		
		while (!lista.getNumeros().isEmpty() || !Lista.repartidorFinish) {

			
			if(!lista.getNumeros().isEmpty() ) {
				numMax = Math.max(lista.extraer(), numMax);
	
			}
			

		}

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

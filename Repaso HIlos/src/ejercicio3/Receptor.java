package ejercicio3;

public class Receptor extends Thread {

	private Lista lista;
	private int numMax;

	
	/*
	 * Cambiar el el boolean y hacer un tipo for en donde se buscara un limite que se irá atcualizando
	 * a medida que va agregando el numero y a la vez no rompa el bucle hasta que termine el repartidor
	 * BUSCAR OTRA MANERA DE TERMINA EL BUCLEL==>boolean
	 * meter el limite desde la lista compartida*/
	public void run() {

		int aux;
		while (!lista.getNumeros().isEmpty() || !Lista.repartidorFinish) {

			aux=lista.extraer();
			
			numMax = Math.max(aux, numMax);
			System.out.println("lista "+lista.getNumeros().isEmpty());
			System.out.println(Lista.repartidorFinish);

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

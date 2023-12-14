package postExamen;

public class Consumidor extends Thread {

	private Lista lista;
	private String cadena;
	private int contador;

	public void run() {

		String cadenaAux;

		while (!Lista.productorFinish || !lista.getCadenas().isEmpty()) {

			if (!lista.getCadenas().isEmpty()) {

				int contadorAux = 0;
				cadenaAux = lista.extraer();

				for (int i = 0; i < cadenaAux.length(); i++) {

					if (cadenaAux.charAt(i) == 'a' || cadenaAux.charAt(i) == 'A') {
						contadorAux++;
					}

				}

				if (contadorAux > contador) {
					cadena = cadenaAux;
					contador = contadorAux;
				}
			}

		}

	}

	public Consumidor(Lista lista) {
		super();
		this.lista = lista;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

}

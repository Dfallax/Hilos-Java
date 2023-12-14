package ejercicioRepaso;

public class Consumidor extends Thread {

	private Lista lista;
	//private Registro registro;
	private String cadena;

	public void run() {

		String split[] = null;

		while (lista.isProductorFinish() || !lista.getNumeros().isEmpty()) {

			if ((cadena = lista.extraer()) != null) {

				split = cadena.split(",");

				for (int i = 0; i < split.length; i++) {

					if (Integer.parseInt(split[i]) == Main.numero) {
						lista.numEnontrado(1);

					}

				}

			}

		}
		System.out.println("termine");

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

}

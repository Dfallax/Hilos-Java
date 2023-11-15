package prexamen;

public class Hilo extends Thread {

	private int digitos_Mayusculas;
	private String cadena;
	private int[] contador;

	public void run() {

		for (int i = 0; i < cadena.length(); i++) {

			if (digitos_Mayusculas==1) {

				if (Character.isDigit(cadena.charAt(i))) {
						
					contador[digitos_Mayusculas]++;			}

			}else {
				
				if (Character.isUpperCase(cadena.charAt(i))) {
					
					contador[digitos_Mayusculas]++;			}

				}
				
			}

		}
	

	public Hilo(int digitos_Mayusculas, String cadena, int[] contador) {
		super();
		this.digitos_Mayusculas = digitos_Mayusculas;
		this.cadena = cadena;
		this.contador = contador;
	}

	public int getDigitos_Mayusculas() {
		return digitos_Mayusculas;
	}

	public void setDigitos_Mayusculas(int digitos_Mayusculas) {
		this.digitos_Mayusculas = digitos_Mayusculas;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public int[] getContador() {
		return contador;
	}

	public void setContador(int[] contador) {
		this.contador = contador;
	}

	

}

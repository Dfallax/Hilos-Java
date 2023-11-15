package prexamen;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String cadena= "pruEBA34%&";
		int [] contador = new int[2];
		int otroCaracter = 0;
		//mayus
		//digitos
		//otros
		
		Hilo h1 = new Hilo(1,cadena,contador);
		Hilo h2 = new Hilo(0,cadena,contador);
		
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
			
			otroCaracter = cadena.length()-(contador[0]+contador[1]);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Numero de digitos: "+ contador[1]);
		System.out.println("Numero de Mayusculas: "+ contador[0]);
		System.out.println("Numero de otros caracteres: " + otroCaracter);

		
	}

}

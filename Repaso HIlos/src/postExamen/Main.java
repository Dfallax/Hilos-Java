package postExamen;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Lista l =  new Lista();
		Consumidor c = new Consumidor(l); 
		Productor p= new Productor(l);
		
		c.start();
		p.start();
		
		try {
			c.join();
			p.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("La cadena con mas letras a es :" +c.getCadena());
		
	}

}

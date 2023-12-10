package ejercicio3;

import java.util.ArrayList;

public class Main {
	public static final int NUM_RECP_LIST = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 long startTime = System.currentTimeMillis();
		ArrayList<Receptor> receptores = new ArrayList<>(); 
		ArrayList<Lista> listas = new ArrayList<>(); 
		Repartidor repartidor;
		
		for (int i = 0; i < NUM_RECP_LIST; i++) {
			
			Lista l = new Lista();
			Receptor r = new Receptor(l);

			r.start();
			receptores.add(r);
			listas.add(l);
			
		}
		
		repartidor = new Repartidor(listas);
		repartidor.start();
		
		
		try {
			repartidor.join();
			 for(int i = 0; i < NUM_RECP_LIST; i++) {
				 receptores.get(i).join();
			 }
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		 for(int i = 0; i < NUM_RECP_LIST; i++) {
			 
			 System.out.println("Repartidor "+(i+1)+") Numero mayor es: " + receptores.get(i).getNumMax());
		 }
		 
		
		 
	        long endTime = System.currentTimeMillis();
	        long totalTime = endTime - startTime;
	        
	        System.out.println("Tiempo transcurrido en milisegundos: " + totalTime);
	  
	}

}

package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Repartidor extends Thread {

	private ArrayList<Lista> listas;
	

	public void run() {
		final String PATH = "ejercicio3.txt";

		try {
			FileReader fr = new FileReader(PATH);
			BufferedReader br = new BufferedReader(fr);
			String read;

			for (int posLista = 0; (read = br.readLine()) != null; posLista++) {
				
				if (posLista == Main.NUM_RECP_LIST) {
					posLista = 0;
				}
				listas.get(posLista).agregar(Integer.parseInt(read));

			}
			System.out.println("REPARTIDOOO");
			Lista.setRepartidorFinish(true);
			

			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Repartidor(ArrayList<Lista> listas) {
		this.listas = listas;

	}

	public ArrayList<Lista> getListas() {
		return listas;
	}

	public void setListas(ArrayList<Lista> listas) {
		this.listas = listas;
	}

	
}

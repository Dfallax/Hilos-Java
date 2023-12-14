package postExamen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {

	private Lista lista;

	public void run() {

		try {
			FileReader fr = new FileReader("archivo.txt");
			BufferedReader br = new BufferedReader(fr);
			String read;

			while ((read = br.readLine()) != null) {

				lista.agregar(read);

			}Lista.setProductorFinish(true);

			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Productor(Lista lista) {
		super();
		this.lista = lista;
	}
	
	

}

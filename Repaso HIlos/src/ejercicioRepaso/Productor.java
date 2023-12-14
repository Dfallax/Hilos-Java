package ejercicioRepaso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {

	private Lista lista;
	private String pathArchivo;


	public void run() {
		
		try {
			FileReader fr = new FileReader(pathArchivo);
			BufferedReader br = new BufferedReader(fr);
			String read;
			
			while((read=br.readLine())!=null) {
				
				lista.agregar(read);
				
			}
			lista.setContadorFinish(1);
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public Productor(Lista lista,String pathArchivo) {
		super();
		this.lista = lista;
		this.pathArchivo = pathArchivo;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}


	public String getPathArchivo() {
		return pathArchivo;
	}


	public void setPathArchivo(String pathArchivo) {
		this.pathArchivo = pathArchivo;
	}


	
	


	
	
	
}

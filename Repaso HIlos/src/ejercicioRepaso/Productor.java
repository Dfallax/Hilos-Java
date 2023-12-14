package ejercicioRepaso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {

	private Lista lista;
	private String nombreArchivo;


	public void run() {
		
		try {
			FileReader fr = new FileReader(nombreArchivo);
			BufferedReader br = new BufferedReader(fr);
			String read;
			
			while((read=br.readLine())!=null) {
				
				lista.agregar(read);
				
			}
			lista.setProductorFinish(false);
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public Productor(Lista lista,String nombreArchivo) {
		super();
		this.lista = lista;
		this.nombreArchivo = nombreArchivo;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}


	
	public String getNombreArchivo() {
		return nombreArchivo;
	}


	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}


	
	
	
}

package prexamenFinal.Threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio2 extends Thread {

	private String path;
	private ejercicio2Registro registro;

	public void run() {

		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String names[];
			String read;
			
			while ((read = br.readLine()) != null) {

				names = read.split(",");
				for (int i = 0; i < names.length; i++) {
					registro.search(names[i]);
				}

			}

			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		}

	}

	public ejercicio2(String path, ejercicio2Registro registro) {
		super();
		this.path = path;
		this.registro = registro;
	}

	public ejercicio2Registro getRegistro() {
		return registro;
	}

	public void setRegistro(ejercicio2Registro registro) {
		this.registro = registro;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}

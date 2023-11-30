package prexamenFinal.Threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Hilo1 extends Thread {
	
	
    private Lista lista;

    public void run() {
        File archivo = new File("ejercicio1.txt");

        try {
        	
            long i = archivo.length();
           
            InputStream is = new FileInputStream(archivo);
            
            while (i != 0) {

                lista.agregar((char) is.read());
                i--;
            }
            
          lista.setProductorFinish(true);
          
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (Exception e) {

        }
    }

    public Hilo1(Lista lista) {
        this.lista = lista;
    }

}

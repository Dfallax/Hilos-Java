package prexamenFinal.Threads;

import java.util.ArrayList;

public class Lista {
    private final int CAPACIDAD = 10;
    private ArrayList<Character> caracteres = new ArrayList<>();
    public boolean productorFinish;
    
    public synchronized void agregar(char letra) {

        while (caracteres.size() == CAPACIDAD) {

            try {
                wait();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
        caracteres.add(letra);
        notifyAll();

    }

    
    public synchronized char quitar() {

        while (caracteres.isEmpty()) {

            try {
                wait();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       

        notifyAll();
   return caracteres.remove(0);

    }

    public int getCAPACIDAD() {
        return CAPACIDAD;
    }

    public ArrayList<Character> getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(ArrayList<Character> caracteres) {
        this.caracteres = caracteres;
    }


    public Lista() {
      
    }


	public boolean isProductorFinish() {
		return productorFinish;
	}


	public void setProductorFinish(boolean productorFinish) {
		this.productorFinish = productorFinish;
	}

	
	
}

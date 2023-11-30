package prexamenFinal.Threads;

public class Hilo2 extends Thread {
    private Lista lista;
    private int contador;
  
    
    public void run() {

       while( !lista.productorFinish ||  !lista.getCaracteres().isEmpty()) {
        	
            char caracter = lista.quitar();
            if (Character.isDigit(caracter)) {
                contador++;
            }
        }
    }
    
    public Hilo2(Lista lista) {
        this.lista = lista;
    }

    public Lista getLista() {
        return lista;
    }
    public void setLista(Lista lista) {
        this.lista = lista;
    }
    public int getContador() {
        return contador;
    }
    public void setContador(int contador) {
        this.contador = contador;
    }

	
    
}

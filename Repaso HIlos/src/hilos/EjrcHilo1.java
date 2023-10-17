package hilos;

import java.util.Random;

public class EjrcHilo1 extends Thread{

	private boolean cara;
	
	public EjrcHilo1() {
		
	}
	
	public void run() {
		cara = new Random().nextBoolean();
	}

	public boolean isCara() {
		return cara;
	}

	public void setCara(boolean cara) {
		this.cara = cara;
	}
	
}

package hilos;

import java.util.Random;

public class Hilos3 extends Thread {

	private int num;
	
	public Hilos3(String name) {

		setName(name);
		
	}
	

	public void run() {
 
		num = new Random().nextInt(0, 101);
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	
	
	

	
	
}

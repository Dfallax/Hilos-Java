package hilos;

import java.util.Random;

public class Hilo5 extends Thread{

	private int num;
	private Resultado balanza;
	private int signo;
	
	public Hilo5(Resultado balanza, int signo) {
		this.balanza=balanza;
	this.signo=signo;
	}
	
	public void run() {
		
		num=new Random().nextInt(0,11);
		balanza.start(num*signo);
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Resultado getBalanza() {
		return balanza;
	}

	public void setBalanza(Resultado balanza) {
		this.balanza = balanza;
	}

	public int getSigno() {
		return signo;
	}

	public void setSigno(int signo) {
		this.signo = signo;
	}
	
	
}

package prexamen;

import java.util.Random;

public class Usuario extends Thread{

	private int ingreso;
	private Fondo fondo;
	
	
	public void run() {
		
		this.ingreso = new Random().nextInt(100,201); 
		fondo.fondoTotal(ingreso);
		
	}
	
	public Usuario(Fondo fondo) {
		
		this.fondo=fondo;
	}
	public Usuario(int ingreso, Fondo fondo) {
		super();
		this.ingreso = ingreso;
		this.fondo = fondo;
	}
	public int getIngreso() {
		return ingreso;
	}
	public void setIngreso(int ingreso) {
		this.ingreso = ingreso;
	}
	public Fondo getFondo() {
		return fondo;
	}
	public void setFondo(Fondo fondo) {
		this.fondo = fondo;
	}
	
	
	
	
}

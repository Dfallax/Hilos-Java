package hilos;

import java.util.ArrayList;

public class Marcador {

	private  ArrayList <String> name = new ArrayList<String>(); 
	
public Marcador() {
	
}
	
public synchronized void Carrera(String name) {
	
	this.name.add(name);
	
}

public ArrayList<String> getName() {
	return name;
}

public void setName(ArrayList<String> name) {
	this.name = name;
}


}

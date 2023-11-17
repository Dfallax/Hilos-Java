package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import clase.Cita;
import clase.Doctor;
import clase.Paciente;

public class Main {

	
	static ArrayList<Paciente> listaPacientes =  new ArrayList<Paciente>();
	static ArrayList<Doctor> listaDoctores = new ArrayList<Doctor>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File histotialCitas = new File("Historial de citas médicas");//CARPETA
		File directoryPacient = new File("Pacientes");//CARPETA
		File idPaciente = new File("id");//CARPETA ---> RELLENAR CON 0 CUNADO NO ALCANCE EL LIMITE
		File pacienteXML = new File("Datos Personales.xml");
		File citasXML = new File("Citas.xml");
		String path = "Historial de pacientes.txt";
		
		//---leer el archivo para extraer la informacion
		
		try {

			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String read;
			
				while ((read=br.readLine()) != null){	

				String datos[]= read.split(",");
				
				
				if(read.charAt(0)=='#') {
					
					
					
				}else {
					
					listaPacientes.add(new Paciente(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5],new Cita()));

				}
				
				
				
					
			
				}
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		/*
		 Crear directorio para cada paciente 
		 */	
		
		if(!directoryPacient.exists()) {
			if(directoryPacient.mkdir()) {
			}		
		}
	//--------------------------------------
		
		
		
		
		
		
	}

}

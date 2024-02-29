package ejercicio_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {
	  
	public static void main(String[] args) {

		try {
			Socket socket = new Socket("192.168.56.1", 6565);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner s = new Scanner(System.in);
			String respuesta;
			String mensaje;

			do {
				System.out.print("Introduce el numero para adivinar ");
				mensaje = s.nextLine();
				dos.writeUTF(mensaje);
				respuesta = dis.readUTF();
				System.out.println(respuesta);

				
			}while(!respuesta.toLowerCase().equals("haz perdido") && !respuesta.toLowerCase().equals("haz ganado"));
			
			System.out.println("Respuesta del server: "+ respuesta);
			// Leemos del teclado y enviamos el mensaje al server
			
			

			// Cierre de todas las conexiones o streams de datos
			s.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
		
}
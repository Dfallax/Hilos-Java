package ejercicio_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServidor {

	public static void main(String[] args) {

		String cadena="";
		
		try {
			ServerSocket serverSocket = new ServerSocket(6565);
			String mensaje;
			Socket socketCliente = serverSocket.accept();
			DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
			DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());	
			do {
				//recibir mensaje del cliente
				mensaje = dis.readUTF();
				if(mensaje.trim().length() >= cadena.length()) {
					cadena = mensaje;
				}
				//System.out.println("Mensaje recibido: " + mensaje);
					
			} while (!mensaje.toLowerCase().equals("fin"));
			dos.writeUTF(cadena);
			dis.close();
			dos.close();
			socketCliente.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
		
	}
	
}

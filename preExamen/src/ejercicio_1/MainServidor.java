package ejercicio_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServidor {

	public static void main(String[] args) {

		ArrayList<String>listaEnteros = new ArrayList<>();
		try {
			ServerSocket serverSocket = new ServerSocket(6565);
			String mensaje;
			Socket socketCliente = serverSocket.accept();
			DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
			DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());	
			do {
				//recibir mensaje del cliente
				mensaje = dis.readUTF();
				try {
					Integer.parseInt(mensaje);
					listaEnteros.add(mensaje);
					
				}catch(Exception e) {
					//System.out.println(e.getMessage());
				}
				//System.out.println("Mensaje recibido: " + mensaje);
					
			} while (!mensaje.toLowerCase().equals("fin"));
			dos.writeUTF(listaEnteros.toString());
			dis.close();
			dos.close();
			socketCliente.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	
		
	}
	
}

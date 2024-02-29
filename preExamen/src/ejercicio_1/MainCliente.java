package ejercicio_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket = new Socket("192.168.56.1", 6565);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner s = new Scanner(System.in);
			String respuesta;
			String mensaje;

			do {
				System.out.print("Introduce el mensaje para el server: ");
				mensaje = s.nextLine();
				dos.writeUTF(mensaje);
				
				
			}while(!mensaje.toLowerCase().equals("fin"));
			respuesta = dis.readUTF();
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

package servidor_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainCliente {
	static Socket socket;
	
	static DataOutputStream dos;
	public static void main(String[] args) {

		try {
			Ventana ventana = new Ventana();
			socket = new Socket("PC18625", 6565);
			ventana.setVisible(true);			
		
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			String mensajeRecibido = "";
			
			//Alberto PC18634
			while (!(mensajeRecibido = dis.readUTF()).trim().toLowerCase().equals("5")) {
				
				ventana.mensajes.append(mensajeRecibido);	
				
			}
			ventana.dispose();
			
			// Cierre de todas las conexiones o streams de datos
			dos.close();
			dis.close();
			socket.close();
			System.out.println("TO SECRRADO");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void enviarMensaje(String mensaje) {
		
	 try {
		
		dos.writeUTF(mensaje);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
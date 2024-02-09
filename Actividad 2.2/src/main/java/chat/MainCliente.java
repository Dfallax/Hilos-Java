package chat;

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
			while (!(mensajeRecibido = dis.readUTF()).trim().toLowerCase().equals("fin")) {
				
				ventana.mensajes.append(mensajeRecibido+"\n");	
				
			}
			
			ventana.dispose();
			
			// Cierre de todas las conexiones o streams de datos
			dos.close();
			dis.close();
			socket.close();
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
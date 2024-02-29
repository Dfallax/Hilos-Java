package ejercicio_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class HiloUsuario extends Thread {
	private Socket socket;
	private int numAdivinar;
	public HiloUsuario(Socket socket, int numAdivinar) {
		this.socket = socket;
		this.numAdivinar = numAdivinar;
	}

	public void run() {
		try {
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String read;
			System.out.println("Numero a adivinar: "+numAdivinar);

			do {
				read =dis.readUTF();
				System.out.println("mensaje recibido: "+ read);
				if(numAdivinar == Integer.parseInt(read)) {
					MainServidor.endServidor = true;
					break;
				}else {
					dos.writeUTF("No es el numero");
				}
				
			}while(true);
				
			for(int i = 0; i < MainServidor.listaConexiones.size(); i++) {
				
				if(MainServidor.listaConexiones.get(i).getSocket().getInetAddress().getHostName().equals(
						socket.getInetAddress().getHostName())) {
					MainServidor.listaConexiones.get(i).enviarMensaje("haz ganado");;
				}
				MainServidor.listaConexiones.get(i).enviarMensaje("haz perdido");;
			}	
			dos.close();
			dis.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}
	public void enviarMensaje(String texto) {
		try {
			DataOutputStream dos;
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(texto);
			dos.close();
		} catch (Exception e) {

		}

	}

}

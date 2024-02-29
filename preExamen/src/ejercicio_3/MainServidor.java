package ejercicio_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.Random;


public class MainServidor {
	public static ArrayList<HiloUsuario> listaConexiones = new ArrayList<>();
	public static boolean endServidor;
	public static void main(String[] args) {
		
		try (ServerSocket serverSocket = new ServerSocket(6565)) {
		int num = new Random().nextInt(10);
		
			while (!endServidor) {
				
				Socket socketCliente = serverSocket.accept();
				HiloUsuario newHilo = new HiloUsuario(socketCliente,num);
				for (int x = 0; x < listaConexiones.size(); x++) {

					if (newHilo.getSocket().getInetAddress().getHostName()
							.equals(listaConexiones.get(x).getSocket().getInetAddress().getHostName())) {

						listaConexiones.remove(x);
						break;
					}
				}
				listaConexiones.add(newHilo);
				newHilo.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

}
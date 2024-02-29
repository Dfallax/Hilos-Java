package servidor_cliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;

import entities.User;

public class MainServidor {
	public static ArrayList<User> listaUsuario;
	public static ArrayList<HiloUsuario> listaConexiones = new ArrayList<>();

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(6565)) {

			while (true) {

				Socket socketCliente = serverSocket.accept();
				HiloUsuario newHilo = new HiloUsuario(socketCliente);
				System.out.println(listaConexiones.size());
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
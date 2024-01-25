import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServidor {

	public static ArrayList<HiloCliente> listaClientes = new ArrayList<>();
	

	public static void main(String[] args) {
		HiloCliente h;
		try (ServerSocket serverSocket = new ServerSocket(6565)) {

			while (true) {
				// accept() es bloqueante
				Socket socketCliente = serverSocket.accept();
				
				
				h = new HiloCliente(socketCliente);
				h.start();
				listaClientes.add(h);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

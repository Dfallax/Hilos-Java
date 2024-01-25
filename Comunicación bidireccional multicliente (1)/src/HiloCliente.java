import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public HiloCliente(Socket socket) {
		this.socket = socket;

	}

	public Socket getSocket() {
		return socket;
	}

	public void run() {
		try {

			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			while (true) {

				String texto = dis.readUTF();
				String mensaje = texto.split(";")[1].toString();
				String destino = texto.split(";")[0].toString();

				for (int x = 0; x < MainServidor.listaClientes.size(); x++) {

					if (MainServidor.listaClientes.get(x).getSocket().getInetAddress().getHostName().equals(destino)) {

						System.out.println(mensaje);
						System.out.println(destino);
						MainServidor.listaClientes.get(x).enviarMensaje(mensaje);
						break;
					}

				}
			}
			// dis.close();
			// dos.close();
			// socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void enviarMensaje(String mensaje) {

		try {
			dos.writeUTF(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

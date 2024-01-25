import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("192.168.128.116", 6565);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);

			//Leemos del teclado y lo enviamos al server
			System.out.print("Introduce el mensaje para el server: ");
			dos.writeUTF(sc.nextLine());

			//Recibimos la respuesta del server
			System.out.println("Respuesta: "+ dis.readUTF());
			
			// Cierre de todas las conexiones o streams de datos
			sc.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

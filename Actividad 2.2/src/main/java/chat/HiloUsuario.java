package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connection.Conexion;
import crud.Crud;
import entities.User;

public class HiloUsuario extends Thread {
	private Socket socket;
	DataOutputStream dos;
	
	public HiloUsuario(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		Scanner s = new Scanner(System.in);
		try {

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			int opcion;
			dos.writeUTF("Selecciona una opcion\n" + "1).Ver\n2).Insertar\n3).Modificar\n4).Borrar\n5).Fin");
			Crud crud = Crud.getInstance();

			while ((opcion = Integer.parseInt(dis.readUTF())) != 5) {

				try (Connection con = Conexion.open()) {

					switch (opcion) {
					case 1:
						crud.getAlluser(con, "SELECT * from usuario");
						dos.writeUTF(MainServidor.listaUsuario.toString());

						break;
					case 2:
						User u = new User();
						dos.writeUTF("Insertando nuevo cliente\nnombre: ");
						u.setNombre(dis.readUTF());
						dos.writeUTF("Apllido 1: ");
						u.setApellido1(dis.readUTF());
						dos.writeUTF("Apllido 2: ");
						u.setApellido2(dis.readUTF());
						dos.writeUTF("Edad: ");
						u.setEdad(Integer.parseInt(dis.readUTF()));
						dos.writeUTF("Nacimiento (YYYY-MM-DD): ");
						u.setNacimiento(dis.readUTF());
						crud.insert(con, u);

						break;
					case 3:
						
						crud.update(con);
						break;
					case 4:
						
						crud.delete(con);
						break;
					}
					
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				System.out.println("Mensaje recibido: " + opcion);

			}

		} catch (IOException e) {
			e.printStackTrace();

		} catch (NumberFormatException n) {

			try {
				dos.writeUTF("ERROR: Coloca una opcion valida");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}

}

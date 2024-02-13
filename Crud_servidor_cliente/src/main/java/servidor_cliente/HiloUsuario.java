package servidor_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;

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
		try {

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			int opcion=0;
			Crud crud = Crud.getInstance();

			do {
				
				try (Connection con = Conexion.open()) {
					
					dos.writeUTF("\nSelecciona una opcion\n" + "1).Ver\n2).Insertar\n3).Modificar\n4).Borrar\n5).Fin\n>>");
					opcion = Integer.parseInt(dis.readUTF());
					
					
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
						dos.writeUTF("USUARIO NUEVO REGISTRADO");
						break;
					case 3:
						
						crud.update(con);
						break;
					case 4:
						
						crud.getAlluser(con, "SELECT * from usuario");
						
						
						dos.writeUTF("Selecciona a cual quiere elimindar\n");
						for (int i = 0; i < MainServidor.listaUsuario.size(); i++) {
							dos.writeUTF((i + 1) + ") " + MainServidor.listaUsuario.get(i).getNombre()+
									" "+MainServidor.listaUsuario.get(i).getApellido1()+
									" "+MainServidor.listaUsuario.get(i).getApellido2()+"\n");
						}
						crud.delete(con,Integer.parseInt(dis.readUTF()));
						dos.writeUTF("REGISTRO ElIMINADO\n");
						break;
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				} catch (NumberFormatException n) {

					try {
						dos.writeUTF("ERROR: Coloca una opcion valida\n");
					} catch (IOException e) {

						e.printStackTrace();
					}

				}

				System.out.println("opcion recibida: " + opcion);

			} while (opcion != 5);
			dos.writeUTF("" + opcion);

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

}

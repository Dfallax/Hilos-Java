package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Conexion;
import entities.User;

public class MainServidor {
	static ArrayList<User> listaUsuario = new ArrayList<>();
	static String respuesta;

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6565);
			String mensaje;

			do {
				// accept() es bloqueante
				Socket socketCliente = serverSocket.accept();
				DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
				DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());
				dos.writeUTF("Selecciona una opcion\n" + "1).Ver\n2).Insertar\n3).Modificar\n4).Borrar");
				mensaje = dis.readUTF();
					
				switch (Integer.parseInt(mensaje)) {
				case 1:
					try (Connection con = Conexion.open()) {
						printSQL(con, "SELECT * from usuario");
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
						dos.writeUTF(listaUsuario.toString());
						
					break;
				case 2:
						
					break;
				}

				// Leemos el mensaje y lo ponemos por consola
				System.out.println(
						"Mensaje de " + socketCliente.getInetAddress().getHostName() + " recibido: " + mensaje);

				// Cerrar conexiones y streams
				dis.close();
				socketCliente.close();
			} while (!mensaje.equals("exit"));

			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void printSQL(Connection con, String query) {
		try (PreparedStatement ps = con.prepareStatement(query)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					User newUser = new User(rs.getInt("id"), rs.getString("name"), rs.getString("apellido1"),
							rs.getString("apellido2"), rs.getInt("edad"), rs.getString("nacimineto"));
					listaUsuario.add(newUser);
				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
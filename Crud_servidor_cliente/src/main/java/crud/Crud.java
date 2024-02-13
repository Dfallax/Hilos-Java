package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import servidor_cliente.MainServidor;
import entities.User;

public class Crud {
	

	private static Crud instance;

	private Crud() {

	}

	public static Crud getInstance() {
		if (instance == null) {
			instance = new Crud();
		}
		return instance;
	}

	public void insert(Connection con, User u) {
		String sql = "INSERT INTO usuario VALUES (NULL,?,?,?,?,?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, u.getNombre());
			ps.setString(2, u.getApellido1());
			ps.setString(3, u.getApellido2());
			ps.setInt(4, u.getEdad());
			ps.setString(5, u.getNacimiento());

			int nFilas = ps.executeUpdate();
			System.out.println("Se han añadido " + nFilas + " filas correctamente");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void update(Connection con) {

		String sql = "UPDATE usuario SET name = ? WHERE id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// ps.setInt(2, primaryKey);
			// ps.setString(1, nuevoNombre);

			int nFilas = ps.executeUpdate();

			System.out.println("Se han modificado " + nFilas + " correctamente");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void delete(Connection con, int primaryKey) {

		String sql = "DELETE FROM usuario WHERE id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, primaryKey);

			int nFilas = ps.executeUpdate();

			System.out.println("Se ha eliminado " + nFilas + " correctamente");

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void getAlluser(Connection con, String query) {
		try (PreparedStatement ps = con.prepareStatement(query)) {
			try (ResultSet rs = ps.executeQuery()) {
				MainServidor.listaUsuario = new ArrayList<>();
				while (rs.next()) {
					User newUser = new User(rs.getInt("id"),rs.getString("name"), rs.getString("apellido1"),
							rs.getString("apellido2"), rs.getInt("edad"), rs.getString("nacimineto"));
					
					MainServidor.listaUsuario.add(newUser);
				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}

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

	public void update(Connection con, int opcionUpdate, String nuevoNombre, String nuevoApellido1, String nuevoApellido2, int nuevaEdad, String nuevoNacimiento) {

	    String sql = "UPDATE usuario SET name = ?, apellido1 = ?, apellido2 = ?, edad = ?, nacimiento = ? WHERE id = ?";

	    try (PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, nuevoNombre);
	        ps.setString(2, nuevoApellido1);
	        ps.setString(3, nuevoApellido2);
	        ps.setInt(4, nuevaEdad);
	        ps.setString(5, nuevoNacimiento);
	        ps.setInt(6, MainServidor.listaUsuario.get(opcionUpdate-1).getId()); 

	        int nFilas = ps.executeUpdate();

	        System.out.println("Se han modificado " + nFilas + " registros correctamente");

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}


	public void delete(Connection con, int opcionDelete) {

		String sql = "DELETE FROM usuario WHERE id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, MainServidor.listaUsuario.get(opcionDelete-1).getId());

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
							rs.getString("apellido2"), rs.getInt("edad"), rs.getString("nacimiento"));
					
					MainServidor.listaUsuario.add(newUser);
				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}

package entities;


public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", appellido1=" + apellido1 + ", appellido2=" + apellido2
				+ ", edad=" + edad + ", nacimiento=" + nacimiento + "]\n";
	}

	// (nombre, apellido1, apellido2, edad (años) y nacimiento
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String nacimiento;

	public User() {

	}

	
	public User(int id, String nombre, String apellido1, String apellido2, int edad, String nacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.nacimiento = nacimiento;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public int getEdad() {
		return edad;
	}

	

	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}

package entities;


public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", appellido1=" + appellido1 + ", appellido2=" + appellido2
				+ ", edad=" + edad + ", nacimiento=" + nacimiento + "]\n";
	}

	// (nombre, apellido1, apellido2, edad (años) y nacimiento
	private int id;
	private String nombre;
	private String appellido1;
	private String appellido2;
	private int edad;
	private String nacimiento;

	public User() {

	}

	
	public User(int id, String nombre, String appellido1, String appellido2, int edad, String nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.appellido1 = appellido1;
		this.appellido2 = appellido2;
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

	

	public String getAppellido1() {
		return appellido1;
	}


	public void setAppellido1(String appellido1) {
		this.appellido1 = appellido1;
	}


	public String getAppellido2() {
		return appellido2;
	}


	public void setAppellido2(String appellido2) {
		this.appellido2 = appellido2;
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

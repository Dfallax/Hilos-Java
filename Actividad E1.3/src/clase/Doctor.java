package clase;

public class Doctor {

	private String nombre;
	private String especialidad;
	
	public Doctor(String nombre, String especialidad) {
		super();
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	
	
}

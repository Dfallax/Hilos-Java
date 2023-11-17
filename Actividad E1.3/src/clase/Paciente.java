package clase;

public class Paciente {

	public static final int MAX_CARACTER = 9;
	
	private int id;
	private String nombre;
	private String Apellido_1;
	private String Apellido_2;
	private String nacimineto;
	private String localidad;
	private Cita cita;
	
	public Paciente(int id, String nombre, String apellido_1, String apellido_2, String nacimineto, String localidad,
			Cita cita) {
		super();
		this.id = id;
		this.nombre = nombre;
		Apellido_1 = apellido_1;
		Apellido_2 = apellido_2;
		this.nacimineto = nacimineto;
		this.localidad = localidad;
		this.cita = cita;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido_1() {
		return Apellido_1;
	}
	public void setApellido_1(String apellido_1) {
		Apellido_1 = apellido_1;
	}
	public String getApellido_2() {
		return Apellido_2;
	}
	public void setApellido_2(String apellido_2) {
		Apellido_2 = apellido_2;
	}
	public String getNacimineto() {
		return nacimineto;
	}
	public void setNacimineto(String nacimineto) {
		this.nacimineto = nacimineto;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public Cita getCita() {
		return cita;
	}
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	public static int getMaxCaracter() {
		return MAX_CARACTER;
	}

	
	
	
	
	
	
}

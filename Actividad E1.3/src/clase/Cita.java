package clase;

public class Cita {

	private Centro centro;
	private Doctor doctor;
	private String fecha;
	private String hora;
	
	
	public Cita(Centro centro, Doctor doctor, String fecha, String hora) {
		super();
		this.centro = centro;
		this.doctor = doctor;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public Cita() {
		
	}
	
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	


}

package tp01.ejercicio3;

public class Estudiante {
	String nombre;
	String apellido;
	String comision;
	String email;
	String direccion;
	
	public Estudiante(String nombre, String apellido, String comision, String email, String direccion) {
		setNombre(nombre);
		setApellido(apellido);
		setComision(comision);
		setEmail(email);
		setDireccion(direccion);
	}
	
	public Estudiante() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", comision=" + comision + ", email=" + email
				+ ", direccion=" + direccion + "]";
	}
	
	public String tusDatos() {
		return toString();
	}
	
}

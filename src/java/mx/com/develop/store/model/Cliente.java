package mx.com.develop.store.model;

public class Cliente {

	private String nombre;
	private int edad;
	private String direccion;
	private String telefono;
	private String usuario;
	private String contrasenia;

	public Cliente() {
	}

	public Cliente(String nombre, int edad, String direccion, String telefono, String usuario, String contrasenia) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

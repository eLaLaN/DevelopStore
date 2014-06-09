package mx.com.develop.store.model;

public class Cliente {

    public Cliente(String nombre, int edad, String direccion, String usuario, String contrasena, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }

    private String nombre;
    private int edad;
    private String direccion;
    private String usuario;
    private String contrasena;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

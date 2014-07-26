package mx.com.develop.store.model;

public class Producto {

    private Integer id;
    private Color color;
    private double precio;
    private Talla talla;
    private String descripcion;
    private TipoProducto tipo;
    private int disponibles;

    public Producto() {
    }

    public int getDisponiblesPorAca() {
        return disponibles;
    }

    public Producto(Integer id, Color color, double precio, Talla talla,
            String descripcion, TipoProducto tipo, int disponibles) {
        this.id = id;
        this.color = color;
        this.precio = precio;
        this.talla = talla;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.disponibles = disponibles;
    }

    @Override
    public Producto clone() {
        Producto producto = new Producto();
        producto.id = id;
        producto.color = color;
        producto.descripcion = descripcion;
        producto.disponibles = disponibles;
        producto.precio = precio;
        producto.talla = talla;
        producto.tipo = tipo;
        return producto;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
}

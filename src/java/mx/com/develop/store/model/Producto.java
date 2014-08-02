package mx.com.develop.store.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// If an object needs to be persisted, this must implement serializable interface
@Entity
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Column
    private double precio;

    @Enumerated(EnumType.STRING)
    private Talla talla;

    @Column
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;

    @Column
    private int disponibles;

    public Producto() {
    }

    public int getDisponiblesPorAca() {
        return disponibles;
    }

    /*public Producto(Integer id, Color color, double precio, Talla talla,
     String descripcion, TipoProducto tipo, int disponibles) {
     this.id = id;
     this.color = color;
     this.precio = precio;
     this.talla = talla;
     this.descripcion = descripcion;
     this.tipo = tipo;
     this.disponibles = disponibles;
     }*/
    public Producto(int id, Color color, double precio, Talla talla,
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

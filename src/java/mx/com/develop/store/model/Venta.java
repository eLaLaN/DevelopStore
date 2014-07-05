package mx.com.develop.store.model;

import java.util.HashMap;
import java.util.Map;

public class Venta {

    private Map<Producto, Integer> productos;

    public Venta() {
        productos = new HashMap<>();
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<Producto, Integer> productos) {
        this.productos = productos;
    }
}

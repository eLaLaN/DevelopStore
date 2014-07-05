package mx.com.develop.store.listeners;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import static javax.servlet.ServletRegistration.Dynamic;

import javax.servlet.annotation.WebListener;
import mx.com.develop.store.model.Cliente;
import mx.com.develop.store.model.Color;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Talla;
import mx.com.develop.store.model.TipoProducto;

@WebListener
public class WebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("WebContextListener.contextInitialized()");
        ServletContext context = sce.getServletContext();

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(productos.size() + 1, Color.ROJO, 167.50, Talla.CHICA, "Playera con estampado de Disney", TipoProducto.PLAYERA, 10));
        productos.add(new Producto(productos.size() + 1, Color.AZUL, 199.99, Talla.GRANDE, "Jeans", TipoProducto.PANTALON, 10));
        productos.add(new Producto(productos.size() + 1, Color.MORADO, 257.00, Talla.MEDIANA, "Blusa con cuello V", TipoProducto.BLUSA, 100));
        productos.add(new Producto(productos.size() + 1, Color.CAFE, 174.50, Talla.EXTRA_GRANDE, "Camisa con boton premium", TipoProducto.CAMISA, 10));
        productos.add(new Producto(productos.size() + 1, Color.NEGRO, 599.99, Talla.CHICA, "Playera para caballero", TipoProducto.PLAYERA, 10));
        context.setAttribute("productos", productos);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Administrador", "", "", "admin", "admin", ""));
        context.setAttribute("clientes", clientes);

        //context.addServlet("RegistroCliente", RegistroCliente.class);
        Dynamic registroClienteServlet = context.addServlet("RegistroCliente", "mx.com.develop.store.controller.RegistroCliente");
        registroClienteServlet.addMapping("/registro_cliente.do");

        for (String urlPattern : registroClienteServlet.getMappings()) {
            System.out.println("urlPatter de RegistroCliente: " + urlPattern);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}

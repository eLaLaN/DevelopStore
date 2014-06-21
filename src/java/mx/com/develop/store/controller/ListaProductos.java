package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Color;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Talla;
import mx.com.develop.store.model.TipoProducto;

@WebServlet(name = "ListaProductos", urlPatterns = {"/lista_productos.view", "/listaProductos"})
public class ListaProductos extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        if (true) { //esta autenticado?
            List<Producto> productos = new ArrayList<>();
            productos.add(new Producto(1, Color.ROJO, 167.50, Talla.CHICA, "Playera con estampado de Disney", TipoProducto.PLAYERA));
            productos.add(new Producto(2, Color.AZUL, 199.99, Talla.GRANDE, "Jeans", TipoProducto.PANTALON));
            productos.add(new Producto(3, Color.MORADO, 257.00, Talla.MEDIANA, "Blusa con cuello V", TipoProducto.BLUSA));
            productos.add(new Producto(4, Color.CAFE, 174.50, Talla.EXTRA_GRANDE, "Camisa con boton premium", TipoProducto.CAMISA));
            productos.add(new Producto(5, Color.NEGRO, 599.99, Talla.CHICA, "Playera para caballero", TipoProducto.PLAYERA));

            request.setAttribute("productos", productos);

            String usuario = "Bruce 'Atributo' Wayne";
            request.setAttribute("usuario", usuario);

            dispatcher = request.getRequestDispatcher("lista_productos.jsp");
        } else {
            //dispatcher = request.getRequestDispatcher("/ayuda");
            //Solo Nombres de Servlet y el servlet debe de soportar el metod HTTP sobre el que se manda llamara el forward
            dispatcher = this.getServletContext().getNamedDispatcher("ServletDeAyuda");
        }

        dispatcher.forward(request, response);
    }

}

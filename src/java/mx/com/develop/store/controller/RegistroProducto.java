package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Color;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Talla;
import mx.com.develop.store.model.TipoProducto;

@WebServlet(name = "RegistroProducto", urlPatterns = {"/admin/registro_producto.do"})
public class RegistroProducto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> listaErrores = new ArrayList<>();
        Color color = null;
        double precio = 0.0;
        Talla talla = null;
        String descripcion;
        TipoProducto tipo = null;
        int disponibles = 0;

        ServletContext context = this.getServletContext();
        List<Producto> productos = (List<Producto>) context.getAttribute("productos");
        if (productos == null) {
            productos = new ArrayList<Producto>();
            context.setAttribute("productos", productos);
        }

        try {
            color = Color.valueOf(request.getParameter("color"));
        } catch (IllegalArgumentException e) {
            listaErrores.add("Debes seleccionar el 'Color' del producto, es un campo obligatorio.");
        }
        try {
            precio = new Double(request.getParameter("precio"));
        } catch (NumberFormatException e) {
            listaErrores.add("El precio debe ser un numero decimal.");
        }
        try {
            talla = Talla.valueOf(request.getParameter("talla"));
        } catch (IllegalArgumentException e) {
            listaErrores.add("Debes seleccionar la 'Talla' del producto, es un campo obligatorio.");
        }
        descripcion = request.getParameter("descripcion");
        try {
            tipo = TipoProducto.valueOf(request.getParameter("tipo"));
        } catch (IllegalArgumentException e) {
            listaErrores.add("Debes seleccionar el 'Tipo' del producto, es un campo obligatorio.");
        }
        try {
            disponibles = Integer.valueOf(request.getParameter("disponibles"));
        } catch (NumberFormatException ex) {
            listaErrores.add("Numero de productos disponibles deber ser entero.");
        }

        if (listaErrores.isEmpty()) {
            Producto producto = new Producto(productos.size() + 1, color, precio, talla, descripcion, tipo, disponibles);
            productos.add(producto);
            request.setAttribute("producto", producto);
            RequestDispatcher rd = //request.getRequestDispatcher("registro_producto_success.jsp");
                    context.getRequestDispatcher("/admin/registro_producto_success.jsp");

            rd.forward(request, response);
        } else {
            request.setAttribute("listaErrores", listaErrores);
            RequestDispatcher rd
                    = //RequestDispatcher del request sustituye la pagina actual por la declarada en getRequestDispatcher()
                    // y preserva el path - request.getRequestDispatcher("registro_producto_error.jsp");
                    //
                    //RequestDispatcher del servletContext elimna todo lo que despues del ContextPath y su getRequestDispatcher()
                    //debe de iniciar con "/" y el path del dipatch debe ser completo
                    context.getRequestDispatcher("/admin/registro_producto_error.jsp");
            rd.forward(request, response);
        }
    }

}

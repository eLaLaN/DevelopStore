package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Venta;
import org.apache.commons.lang3.math.NumberUtils;

@WebServlet(name = "AgregarCarrito", urlPatterns = {"/ventas/agregar_carrito.do"})
public class AgregarCarrito extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            ServletContext context = getServletContext();
            int idProducto = Integer.parseInt(request.getParameter("id"));

            List<Producto> productos = (List<Producto>) context.getAttribute("productos");

            Producto productoEncontrado = null;
            for (Producto producto : productos) {
                if (producto.getId().equals(idProducto)) {
                    productoEncontrado = producto;
                    break;
                }
            }

            if (productoEncontrado != null) {
                int cantidad = 0;
                String cantidadStr = request.getParameter("cantidad");

                if (NumberUtils.isDigits(cantidadStr)) {
                    cantidad = Integer.parseInt(cantidadStr);
                }

                int disponibles = productoEncontrado.getDisponibles() - cantidad;

                if (disponibles > -1) {
                    productoEncontrado.setDisponibles(disponibles);
                    Venta venta = (Venta) session.getAttribute("venta");
                    if (venta == null) {
                        venta = new Venta();
                        venta.setProductos(new HashMap<Producto, Integer>());
                        session.setAttribute("venta", venta);
                    }

                    if (venta.getProductos().get(productoEncontrado) == null) {
                        venta.getProductos().put(productoEncontrado, cantidad);
                    } else {
                        venta.getProductos().put(productoEncontrado, venta.getProductos().get(productoEncontrado) + cantidad);
                    }

                    request.getRequestDispatcher("lista_carrito.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("agregar_carrito_error.jsp").forward(request, response);
                }
            } else {
                this.getServletContext().getRequestDispatcher("/ventas/agregar_carrito_error.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("../login.html");
        }
    }

}

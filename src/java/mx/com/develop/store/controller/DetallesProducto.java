package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.develop.store.model.Producto;

@WebServlet(name = "ProductoDetalles", urlPatterns = {"/ventas/detalles_producto.view"})
public class DetallesProducto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("cliente") != null) {
                ServletContext context = getServletContext();
                List<Producto> productos = (List<Producto>) getServletContext().getAttribute("productos");
                Integer idProducto = Integer.parseInt(request.getParameter("id"));
                boolean encontrado = false;

                if (productos != null) {
                    for (Producto producto : productos) {
                        if (idProducto.equals(producto.getId())) {
                            request.setAttribute("producto", producto);
                            encontrado = true;
                            break;
                        }
                    }

                    if (encontrado) {
                        request.getRequestDispatcher("detalles_producto.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("detalles_producto_error.jsp");
                    }
                } else {
                    response.sendRedirect("lista_productos_error.jsp");
                }
            } else {
                response.sendRedirect("../login.html");
            }
        } else {
            response.sendRedirect("../login.html");
        }
    }

}

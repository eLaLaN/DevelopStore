package mx.com.develop.store.controller;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Producto;

@WebServlet(name = "ProductoDetalles", urlPatterns = {"/ventas/detalles_producto.view"})
public class DetallesProducto extends HttpServlet {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer idProducto = Integer.parseInt(request.getParameter("id"));
        boolean encontrado = false;

        Query productoQuery = entityManager.createQuery("SELECT p FROM Producto p WHERE p.id = :productoId");
        productoQuery.setParameter("productoId", idProducto);

        Producto producto = (Producto) productoQuery.getSingleResult();

        if (producto != null) {
            request.setAttribute("producto", producto);
            encontrado = true;
        } else {
            response.sendRedirect("lista_carrito_error.jsp");
        }

        if (encontrado) {
            request.getRequestDispatcher("detalles_producto.jsp").forward(request, response);
        } else {
            response.sendRedirect("detalles_producto_error.jsp");
        }

    }

}

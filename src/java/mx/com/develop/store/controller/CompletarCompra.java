package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.develop.store.model.Cliente;
import mx.com.develop.store.model.Factura;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Venta;

@WebServlet(name = "CompletarCompra", urlPatterns = {"/ventas/completar_compra.do"})
public class CompletarCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ServletContext context = getServletContext();

        if (session != null) {
            Venta venta = (Venta) session.getAttribute("venta");
            if (venta != null) {
                Map<Producto, Integer> productos = venta.getProductos();
                double total = 0.0;
                Set<Producto> set = productos.keySet();
                for (Producto producto : set) {
                    total += producto.getPrecio() * productos.get(producto);
                }
                //Cupones de descuento.
                //Vaciar el crrito de compras.
                session.removeAttribute("venta");

                //Cupones de descuento.
                String cupones = "fHue274, HhsdE78, jads87";
                //Vaciar el crrito de compras.
                session.removeAttribute("venta");
                //Compartir los productos del carrito, los cupones y el total de la compra.
                request.setAttribute("cupones", cupones);

                //Compartir los productos del carrito, los cupones y el total de la compra.
                request.setAttribute("venta", venta);
                request.setAttribute("total", total);

                Factura factura = new Factura();
                factura.setCliente(new Cliente());
                //request.setAttribute("factura", factura);

                request.getRequestDispatcher("completar_compra.jsp").forward(request, response);
            } else {
                venta = new Venta();
                response.sendRedirect("lista_carrito_error.jsp");
            }
        } else {
            response.sendRedirect("lista_carrito_error.jsp");
        }
    }
}

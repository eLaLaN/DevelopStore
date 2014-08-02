package mx.com.develop.store.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import mx.com.develop.store.model.Color;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Talla;
import mx.com.develop.store.model.TipoProducto;

@WebServlet(name = "RegistroProducto", urlPatterns = {"/admin/registro_producto.do"})
@MultipartConfig
public class RegistroProducto extends HttpServlet {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> listaErrores = new ArrayList<>();
        Color color = null;
        double precio = 0.0;
        Talla talla = null;
        String descripcion;
        TipoProducto tipo = null;
        int disponibles = 0;

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

        RequestDispatcher rd;
        if (listaErrores.isEmpty()) {

            Producto producto = new Producto(0, color, precio, talla, descripcion, tipo, disponibles);
            try {
                userTransaction.begin();
                entityManager.persist(producto);
                //Muchas cosas malas que pueden hacer que no funcione, y se necesita hacer rollBack
                //userTransaction.rollback();
                userTransaction.commit();

            } catch (NotSupportedException | SystemException ex) {
                //UserTransaction.begin();
                rd = request.getRequestDispatcher("/error/exception.jsp");
                request.setAttribute("exception", ex);
                rd.forward(request, response);
                return;
            } catch (RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                //UserTransaction.commit();
                rd = request.getRequestDispatcher("/error/exception.jsp");
                request.setAttribute("exception", ex);
                rd.forward(request, response);
                return;
            }
            request.setAttribute("producto", producto);

            //Multipart Forms
            Part uploadedFile = request.getPart("imagen");
            InputStream is = uploadedFile.getInputStream();

            String outputImage = this.getServletContext().getRealPath("/admin/prodImages/" + producto.getId() + ".png");

            OutputStream os = new FileOutputStream(outputImage);
            int read = is.read();
            while (read != -1) {
                os.write(read);
                read = is.read();
            }

            /*
             -- request.getRequestDispatcher() vs servletContext.getRequestDispatcher()
             -- servletContext.getRequestDispatcher() - El path siempre debe ser absoluto, empezar con /
             -- request.getRequestDispatcher() - El path puede ser absoluto o relativo, no necesita empezar con /
             */
            rd = //request.getRequestDispatcher("registro_producto_success.jsp");
                    this.getServletContext().getRequestDispatcher("/admin/registro_producto_success.jsp");

            rd.forward(request, response);

        } else {
            request.setAttribute("listaErrores", listaErrores);
            rd = //RequestDispatcher del request sustituye la pagina actual por la declarada en getRequestDispatcher()
                    // y preserva el path - request.getRequestDispatcher("registro_producto_error.jsp");
                    //
                    //RequestDispatcher del servletContext elimna todo lo que despues del ContextPath y su getRequestDispatcher()
                    //debe de iniciar con "/" y el path del dipatch debe ser completo
                    this.getServletContext().getRequestDispatcher("/admin/registro_producto_error.jsp");
            rd.forward(request, response);
        }
    }

}

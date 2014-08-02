package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Producto;

@WebServlet(name = "ListaProductos", urlPatterns = {"/lista_productos.view", "/listaProductos"})
public class ListaProductos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        if (true) { //esta autenticado?
            List<Producto> productos = (List<Producto>) this.getServletContext().getAttribute("productos");

            if (productos.size() > 0) {
                //Clon de la lista productos que esta en ServletContext
                productos = Arrays.asList(productos.toArray(new Producto[0]));

                //Ahora hay dos attributos de nombre productos en dos scopes diferentes, application/servletContext y request
                request.setAttribute("productos", productos);

                //Aunque se clono la lista, los elementos de ambas listas siguen haciendo referencia a los mismos objectos
                //Se clona el primer elemento de la lista, asi el primer elemento de productos en el scope de request
                //es diferente al primer elemento de productos del scope de application
                Producto producto = productos.get(0).clone();
                producto.setDisponibles(producto.getDisponibles() - 1);
                productos.set(0, producto);
            }

            //Remplazado por el objeto clientes que se encuentra en session
            //String usuario = "Bruce 'Atributo' Wayne";
            //request.setAttribute("usuario", usuario);
            dispatcher = request.getRequestDispatcher("lista_productos.jsp");
        } else {
            //dispatcher = request.getRequestDispatcher("/ayuda");
            //Solo Nombres de Servlet y el servlet debe de soportar el metod HTTP sobre el que se manda llamara el forward
            dispatcher = this.getServletContext().getNamedDispatcher("ServletDeAyuda");
        }

        dispatcher.forward(request, response);
    }

}

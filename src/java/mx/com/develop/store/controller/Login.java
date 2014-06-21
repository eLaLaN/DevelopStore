package mx.com.develop.store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/login.do"}, initParams = {
    @WebInitParam(name = "usuario", value = "admin"),
    @WebInitParam(name = "contrasena", value = "qwerty")})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        //Un Redirect siempre lo va a hacer el cliente,
        //el cliente recibe como respuesta un 302
        //y un header de Location hacia donde se hara el redirect.
        //El request y response del Location sera instancias nuevas y diferentes
        //a las del servler/jsp que mando llamar el sendRedirect
        if (usuario.equals(this.getInitParameter("usuario")) && password.equals(this.getServletConfig().getInitParameter("contrasena"))) {
            response.sendRedirect("lista_productos.view");
        } else {
            response.sendRedirect("login_error.jsp");
            //response.sendRedirect("http://www.google.com?search=cualquier Busqueda");

            //Despues de un redirect todo el body del response se pierde
            response.getWriter().println("CualquierCosa");
        }
    }

}

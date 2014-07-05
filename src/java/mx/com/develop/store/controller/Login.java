package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.develop.store.model.Cliente;

@WebServlet(name = "Login", urlPatterns = {"/login.do"}, initParams = {
    @WebInitParam(name = "userParamName", value = "usuario"),
    @WebInitParam(name = "passParamName", value = "password")})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter(this.getInitParameter("userParamName"));
        String password = request.getParameter(this.getServletConfig().getInitParameter("passParamName"));

        List<Cliente> clientes = (List<Cliente>) this.getServletContext().getAttribute("clientes");
        //Un Redirect siempre lo va a hacer el cliente,
        //el cliente recibe como respuesta un 302
        //y un header de Location hacia donde se hara el redirect.
        //El request y response del Location sera instancias nuevas y diferentes
        //a las del servler/jsp que mando llamar el sendRedirect
        if (clientes != null) {
            Cliente clienteEncontrado = null;
            for (Cliente cliente : clientes) {
                if (usuario.equalsIgnoreCase(cliente.getUsuario()) && password.equals(cliente.getContrasena())) {
                    clienteEncontrado = cliente;
                    break;
                }
            }

            if (clienteEncontrado != null) {
                HttpSession session = request.getSession();

                System.out.println("Default Session TimeOut: " + session.getMaxInactiveInterval());
                session.setMaxInactiveInterval(60 * 60);
                System.out.println("New Session TimeOut: " + session.getMaxInactiveInterval());

                System.out.println("Session CreationTime: " + new Date(session.getCreationTime()));
                System.out.println("Session LastAccessedTime: " + new Date(session.getLastAccessedTime()));

                Cookie clienteCookie = new Cookie("nombreCliente", clienteEncontrado.getNombre());
                clienteCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(clienteCookie);

                session.setAttribute("cliente", clienteEncontrado);
                response.sendRedirect(response.encodeRedirectURL("lista_productos.view"));
            } else {
                response.sendRedirect("login_error.jsp");
            }

        } else {
            response.sendRedirect("login_error.jsp");
            //response.sendRedirect("http://www.google.com?search=cualquier Busqueda");

            //Despues de un redirect todo el body del response se pierde
            response.getWriter().println("CualquierCosa");
        }
    }

}

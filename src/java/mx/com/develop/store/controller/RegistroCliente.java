package mx.com.develop.store.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Cliente;

@WebServlet(name = "RegistroCliente", urlPatterns = {"/registro_cliente.do"})
public class RegistroCliente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        Cliente cliente = new Cliente(nombre, edad, direccion, usuario, contrasena, telefono);

        request.setAttribute("cliente", cliente);

        RequestDispatcher dispatcher = request.getRequestDispatcher("registro_cliente_success.jsp");
        dispatcher.forward(request, response);
    }
}

package mx.com.develop.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroCliente", urlPatterns = {"/registro_cliente.view"})
public class RegistroCliente extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		System.out.println(nombre);
		int edad = Integer.parseInt(request.getParameter("edad"));
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasenia");

		Cliente cliente = new Cliente(nombre, edad, direccion, telefono, usuario, contrasena);;
		request.setAttribute("cliente", cliente);

		request.getRequestDispatcher("registro_cliente_success.jsp").forward(request, response);
	}
}
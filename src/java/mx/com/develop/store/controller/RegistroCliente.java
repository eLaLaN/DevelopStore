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

    /*
	public RegistroCliente(String hello) {
	System.out.println(hello);
	}
	*/

	public RegistroCliente() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("En public void init()");
		super.init(); // To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("En  public void init(ServletConfig config)");
		super.init(config); // To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void destroy() {
		System.out.println("En public void destroy()");
		super.destroy(); // To change body of generated methods, choose Tools | Templates.
	}

	/*
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("En public void service(ServletRequest req, " + "ServletResponse res)");
		super.service(req, res); // To change body of generated methods, choose Tools | Templates.
		// doPost((HttpServletRequest) req, (HttpServletResponse) res);
	}
	*/

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("En protected void service(HttpServletRequest " + "req, HttpServletResponse resp)");
		// super.service(req, resp); // To change body of generated methods, choose Tools | Templates.
		// System.out.println(getServletConfig());

		System.out.println("Informacion de Request:");
		System.out.println("Protocol: " + req.getProtocol());

		System.out.println("ContextPath: " + req.getContextPath());
		System.out.println("RequestURI: " + req.getRequestURI());

		System.out.println("User-Agent: " + req.getHeader("User-Agent"));
		Enumeration <String> headers = req.getHeaderNames();

		while (headers.hasMoreElements())
		{
			String header = headers.nextElement();
			System.out.println("Header: " + header + " value: " + req.getHeader(header));
		}
		System.out.println("content-length-int: " + req.getIntHeader("content-length"));
		if (req.getMethod().equals("POST"))
		{
			doPost(req, resp);
		}
		System.out.println("RequestURI: " + req.getRequestURI());
		System.out.println("RequestURL: " + req.getRequestURL());
		System.out.println("ServletPath: " + req.getServletPath());
	}
}

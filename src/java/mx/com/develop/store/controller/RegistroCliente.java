package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Cliente;

@WebServlet(name = "RegistroCliente", urlPatterns = {"/registro_cliente.do"})
public class RegistroCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int edad = 9999;
        try {
            edad = Integer.parseInt(request.getParameter("edad"));
        } catch (Exception ex) {
        }
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        Cliente cliente = new Cliente(nombre, edad, direccion, usuario, contrasena, telefono);

        request.setAttribute("cliente", cliente);

        RequestDispatcher dispatcher = request.getRequestDispatcher("registro_cliente_success.jsp");
        dispatcher.forward(request, response);

    }

    public RegistroCliente(String arg) {
        System.out.println("Hola Mundo con argumentos!!!");
    }

    // 1. Container crea la instancia
    public RegistroCliente() {
        System.out.println("Hola Mundo!!!");
    }

    // 2. Container llama metodo init(ServletConfig)
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Llamada desde el metodo init(ServletConfig)");
        super.init(config);
    }

    // 2.1. init(ServletConfig) llama init()
    @Override
    public void init() {
        System.out.println("Llamada desde el metodo init()");
    }

    //3. Container manda llamar el metodo service() de Servlet por cada transaccion
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("Llamada desde el metodo service(ServletRequest, ServletResponse)");

        //doPost((HttpServletRequest)request, (HttpServletResponse)response);
        super.service(request, response);
    }

    //3.1 Service de HTTP
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Llamada desde el metodo service(HttpServletRequest, HttpServletResponse)");

        //Opcion 1.
        //super.service(request, response);
        //Opcion 2.
        doPost(request, response);

        //Opcion 3.
        System.out.println("Informacion del Request: ");
        System.out.println("Protocol: " + request.getProtocol());

        System.out.println("ContextPath: " + request.getContextPath());
        System.out.println("RequestURI: " + request.getRequestURI());
        System.out.println("RequestURL: " + request.getRequestURL());
        System.out.println("ServletPath: " + request.getServletPath());

        System.out.println("User-Agent: " + request.getHeader("User-Agent"));

        System.out.println("Todos los ReqestHeaders:");
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            System.out.println(headerName + ": " + request.getHeader(headerName));
        }

        switch (request.getMethod()) {
            case "POST":
                doPost(request, response);
                break;
            case "GET":
                doGet(request, response);
                break;
        }

    }

    //4. Container llama el destroy cuando se "baja" la aplicacion
    @Override
    public void destroy() {
        System.out.println("Llamada desde el metodo destroy()");
    }
}

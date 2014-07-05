package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Cliente;
import mx.com.develop.store.model.Producto;
import org.apache.commons.lang3.StringUtils;

//@WebServlet(name = "RegistroCliente", urlPatterns = {"/registro_cliente.do"})
public class RegistroCliente extends HttpServlet {

    public RegistroCliente(String arg) {
        System.out.println("new RegistroCliente(String)");
    }

    // 1. Container crea la instancia
    public RegistroCliente() {
        System.out.println("new RegistroCliente()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String captcha = request.getParameter("captcha");

        ServletContext context
                = //this.getServletContext();
                //request.getServletContext();
                this.getServletConfig().getServletContext();

        List<Cliente> clientes = (List<Cliente>) context.getAttribute("clientes");
        if (clientes == null) {
            clientes = new ArrayList<Cliente>();
            context.setAttribute("clientes", clientes);
        }

        boolean captchaError = true;
        Enumeration<String> captchaValues = context.getInitParameterNames();
        while (captchaValues.hasMoreElements()) {
            String captchaValue = captchaValues.nextElement();
            if (captcha.equals(context.getInitParameter(captchaValue))) {
                captchaError = false;
            }
        }

        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        if (captchaError
                || StringUtils.isBlank(nombre) || StringUtils.isBlank(usuario) || StringUtils.isBlank(contrasena)) {
            response.sendRedirect("registro_cliente_error.jsp");
        } else {
            Cliente cliente = new Cliente(nombre, edad, direccion, usuario, contrasena, telefono);
            clientes.add(cliente);
            request.setAttribute("cliente", cliente);

            RequestDispatcher dispatcher = request.getRequestDispatcher("registro_cliente_success.jsp");
            dispatcher.forward(request, response);
        }
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
        //doPost(request, response);
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

        //Opcion 3.
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

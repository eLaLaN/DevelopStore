package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Talla;
import mx.com.develop.store.model.Color;
import mx.com.develop.store.model.TipoProducto;

@WebServlet(name = "ListaProductos", urlPatterns = { "/lista_productos.view" })
public class ListaProductos extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * 
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <Producto> productos = new LinkedList <Producto>();

		productos.add(new Producto(1, Color.ROJO, 167.50, Talla.CHICA, "Playera con estampado de Disney.", TipoProducto.PLAYERA));
		productos.add(new Producto(2, Color.AZUL, 199.99, Talla.GRANDE, "Pantalón de mezclilla.", TipoProducto.PANTALON));
		productos.add(new Producto(3, Color.MORADO, 257.99, Talla.MEDIANA, "Blusa morada con cuello V.", TipoProducto.BLUSA));
		productos.add(new Producto(4, Color.CAFE, 174.50, Talla.GRANDE, "Camisa con boton premium.", TipoProducto.CAMISA));
		productos.add(new Producto(5, Color.NEGRO, 480.99, Talla.EXTRA_GRANDE, "Playera para caballero con estampado de Dinosaurio.", TipoProducto.PLAYERA));

		String usuario = "Bruce Wayne";
		request.setAttribute("usuario", usuario);
		request.setAttribute("productos", productos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("lista_productos.jsp");
		dispatcher.forward(request, response);
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}

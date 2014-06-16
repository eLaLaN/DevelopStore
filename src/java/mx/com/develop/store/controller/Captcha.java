package mx.com.develop.store.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Captcha", urlPatterns = {"/captcha.img"})
public class Captcha extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/png");
        //Status es solo una bandera en el cliente
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        //Se genera el error, y el cliente recibe el statusCode del error
        //response.sendError(HttpServletResponse.SC_NOT_FOUND);
        System.out.println("Is Comitted: " + response.isCommitted());
        //response.setHeader("Server", "my-header-value");
        response.addHeader("Server", "my-header-value");

        int aleatorio = ((int) (Math.random() * (3 - 1 + 1) + 1));
        ServletContext context = request.getServletContext();
        InputStream imageReader = context.getResourceAsStream("/imagenes/" + aleatorio + ".png");

        try (OutputStream imageWriter = response.getOutputStream()) {
            int read = 0;
            byte[] imageBytes = new byte[1024];
            while ((read = imageReader.read(imageBytes)) != -1) {
                imageWriter.write(imageBytes, 0, read);
            }

            imageWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Is Comitted: " + response.isCommitted());
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

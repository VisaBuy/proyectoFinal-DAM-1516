
package servlet;

import controlador.ConsultasUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**Esta clase crea un objeto de tipo ConsultarGastos y luego llama a la método autenticar pasandole el usuario y contraseña recibidos 
 del atributos del objeto request optenido del formulario web*/
public class IniciarSesion extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Almaceno los datos del formulario de inicio en las variables usuario y contrasena
        String usuario  = request.getParameter("user");
        String contrasena  = request.getParameter("pass");
        ConsultasUsuarios us = new ConsultasUsuarios();
        
        /**En caso de que la función devuelva TRUE se creara una sesión, y se redigira al usuario a la pagina de gastos.
         En caso contrario se redirigira a la pagina de inicio de sesión.*/
        if(us.autenticacion(usuario,contrasena))  {
            // Creo el objeto para la session
            HttpSession osesion = request.getSession(true);
            osesion.setAttribute("usuario",usuario);
            response.sendRedirect("gastos.jsp");
        }else{
          
            response.sendRedirect("index.jsp");
        }  
        
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

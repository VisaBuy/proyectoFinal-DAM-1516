package servlet;

import controlador.ConsultasUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhon
 */
/**Recoge los datos del formulario, luego crea un objeto  ConsultaUsuario y le pasa como parametros todos los datos del usuario.*/
public class RegistrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
        String nom, ape, usu, cont;
        float suel;
        nom =request.getParameter("nombre");
        ape = request.getParameter("apellido");
        suel = Float.parseFloat(request.getParameter("sueldo"));
        usu = request.getParameter("usuario");
        cont = request.getParameter("contrasena");
        
        ConsultasUsuarios r= new ConsultasUsuarios();
        
        if (r.registroUsuario(nom, ape, suel, usu, cont)==true){
            response.sendRedirect("index.jsp");
        }else{
                 response.sendRedirect("registroUsuario.jsp");
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

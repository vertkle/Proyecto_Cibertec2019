
package Servlets;

import Controlador.UsuarioDAO;
import Modelo.UsuarioPOJO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Klevert
 */
@WebServlet(name = "validar", urlPatterns = {"/validar"})
public class validar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String dni=request.getParameter("etdni");
            String pass=request.getParameter("etpass");
    
    UsuarioDAO usuDAO=new UsuarioDAO();
    UsuarioPOJO usu=usuDAO.ValidarUsuario(dni, pass);
    
    if(usu!=null){
        request.getSession().setAttribute("dni", usu.getDni());
        if(usu.getFk_area()==1){
            response.sendRedirect("menu1.jsp");
        }else{
            response.sendRedirect("menu2.jsp");
        }
        
    }else{
        out.print("error"+ pass);
        response.sendRedirect("login_error.html");
    }
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

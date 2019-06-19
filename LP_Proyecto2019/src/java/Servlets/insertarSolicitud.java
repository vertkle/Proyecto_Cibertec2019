
package Servlets;

import Controlador.SolicitudDAO;
import Controlador.UsuarioDAO;
import Modelo.DetalleSolicitudPOJO;
import Modelo.SolicitudPOJO;
import Modelo.UsuarioPOJO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "insertarSolicitud", urlPatterns = {"/insertarSolicitud"})
public class insertarSolicitud extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String descripcion=request.getParameter("etDescripcion");
    String fecha=request.getParameter("etFecha");
    SolicitudDAO  soliDAO=new SolicitudDAO();
    
     UsuarioDAO usuDao=new UsuarioDAO();
     String usu_dni=request.getSession().getAttribute("dni").toString();
     UsuarioPOJO usu=usuDao.RecuperarUsuario(usu_dni);
     
     SolicitudPOJO soli=new SolicitudPOJO(0,descripcion, fecha, usu.getDni(), usu.getFk_area(),"");
      
      
     HttpSession sesion=request.getSession();
     ArrayList<DetalleSolicitudPOJO>listaDetalle=new ArrayList<DetalleSolicitudPOJO>();
      if(sesion.getAttribute("detalle")!=null){
          listaDetalle=(ArrayList<DetalleSolicitudPOJO>)sesion.getAttribute("detalle");
       }
      //insertando a la bd la solicitud          
     soliDAO.insertarSolicitud(soli, listaDetalle);
     
     //Eliminando la session del detalle
     request.getSession().removeAttribute("detalle");
     
     response.sendRedirect("menu2.jsp");
            
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

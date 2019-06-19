
package Servlets;

import Modelo.DetalleSolicitudPOJO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "detalleSolicitud", urlPatterns = {"/detalleSolicitud"})
public class detalleSolicitud extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int fkProfesion=Integer.parseInt(request.getParameter("etprofesion"));
    double salario=Double.parseDouble(request.getParameter("etSalario"));
    int cantidadPersonal=Integer.parseInt(request.getParameter("etCantidadPersonal"));
    
   DetalleSolicitudPOJO deta=new DetalleSolicitudPOJO(fkProfesion, salario, cantidadPersonal);
  
   ArrayList<DetalleSolicitudPOJO> listaDeta=(ArrayList<DetalleSolicitudPOJO>)request.getSession().getAttribute("detalle");
   
   if(listaDeta==null){
       listaDeta=new ArrayList<DetalleSolicitudPOJO>();
       listaDeta.add(deta);
       request.getSession().setAttribute("detalle", listaDeta);
   }else{
       listaDeta.add(deta);
       request.getSession().setAttribute("detalle", listaDeta);
   }
   
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

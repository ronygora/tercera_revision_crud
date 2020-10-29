/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloMedicina.Medicina;
/**
 *
 * @author Dlope
 */
public class sr_medicina extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Medicina medicina;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_medicina</title>");            
            out.println("</head>");
            out.println("<body>");
            medicina = new Medicina (request.getParameter("txt_nombre_medicina"),Integer.valueOf(request.getParameter("drop_tipo_medicina")),Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("txt_existencia")),request.getParameter("txt_lote_medicina"),request.getParameter("txt_descripcion_medicina"));

            if("agregar".equals(request.getParameter("btn_agregar"))){
           
            if (medicina.agregar()>0){
                
            response.sendRedirect("index_medicina.jsp");
        }
            else{
                    out.println("<h1>error.......</h1>");
                    out.println("<a href='index_medicina.jsp'>Regresar</a>");
                    }
            }
             if("modificar".equals(request.getParameter("btn_modificar"))){
           
            if (medicina.modificar()>0){
                
            response.sendRedirect("index_medicina.jsp");
        }
            else{
                    out.println("<h1>error.......</h1>");
                    out.println("<a href='index_medicina.jsp'>Regresar</a>");
                    }
            }
            if("eliminar".equals(request.getParameter("btn_eliminar"))){
           
            if (medicina.eliminar()>0){
                
            response.sendRedirect("index_medicina.jsp");
        }
            else{
                    out.println("<h1>error.......</h1>");
                    out.println("<a href='index_medicina.jsp'>Regresar</a>");
                    }
            }
            out.println("</body>");
            out.println("</html>");
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

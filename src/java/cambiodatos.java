/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
@WebServlet(name = "cambiodatos", urlPatterns = {"/cambiodatos"})
public class cambiodatos extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cambiodatos</title>");            
            HttpSession session = request.getSession(true);
         Object user = session.getAttribute("currentSessionUser");
            out.println("<title>Servlet cambiodatos</title>");            
            out.println("</head>");
            out.println("<body>");
            String  nombre= request.getParameter("nombre1");
             
    out.println("<div class='headermenu'><div class=\"logininfo\">Usted está ingresado como "+user);
           
          out.println(" <h1 class=\"headermain\">"+user+": Perfil público</h1>\n");
            out.println("<form align='center' id='form1' name='form1' method='post' action='efectuarcambiodatos'>");
            out.println("<table width='600' border='5' cellspacing='0' cellpadding='0'>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>Usuario </th>");
            out.println("<td width='477'>");
            out.println("<input  width='436'type='text' name='usuario' id='correo' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Nombre </th>");
            out.println("<td width='477'>");
            out.println("<input  width='436'type='text' name='nombre' id='correo' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Apellido paterno </th>");
            out.println("<td width='477'>");
            out.println("<input  width='436'type='text' name='paterno' id='correo' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Apellido materno </th>");
            out.println("<td width='477'>");
            out.println("<input  width='436'type='text' name='materno' id='correo' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>contraseña </th>");
            out.println("<td width='477'>");
            out.println("<input  width='436'type='text' name='contrasena' id='correo' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>fecha de nacimiento AAA/MM/DD </th>");
            out.println("<td width='477'>");
            out.println("<input  width='436'type='text' name='nacimiento' id='correo' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Correo </th>");
            out.println("<td width='477'>");
            out.println("<input  width='436'type='text' name='correo' id='correo' /></td>");
            out.println("</tr>");
                        
            out.println("</table>");
            out.println("<input align='center' type='submit' name='aceptar' id='aceptar' value='Cambiar datos' />");
            String nombre1 = nombre;
            out.println("</form>");
             
      
      
    
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

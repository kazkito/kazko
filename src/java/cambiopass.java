/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ruth
 */
@WebServlet(urlPatterns = {"/cambiopass"})
public class cambiopass extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            HttpSession session = request.getSession(true);
         Object user = session.getAttribute("currentSessionUser");
         Object style = session.getAttribute("style");
         Object menu = session.getAttribute("menu");
            out.println("<head> "+style+" ");
            out.println("<title>Servlet cambiopass</title>");            
            out.println("</head>");
            out.println("<body>");
             if(user != null){
 out.println(menu); 
         
         out.println(" <form  id='form1' name='form1' method='post' action='efectuarcambiouser'>");
            out.println("Cambiar nombre de usuario: <p><table align='center' width='600' border='0' cellspacing='0' cellpadding='0'>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>Escriba su nuevo nombre de usuario</th>");
            out.println("<td width='477'>");
            out.println("<input width='477' type='text' name='usuario' id='usuario' /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<p><input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' /></form>");
            out.println(" <form  id='form1' name='form1' method='post' action='efectuarcambiopass'>");
            out.println("Cambiar nombre de contrasena: <p><table align='center' width='600' border='0' cellspacing='0' cellpadding='0'>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>Escriba su contraseña</th>");
            out.println("<td width='477'>");
            out.println("<input width='477' type='text' name='contrasena' id='contrasena' /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<p><input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' />");
            out.println("<input name='Volver' type='reset' value='Volver' onClick='history.back()'> </form>");
             }
         else{
                 out.println(menu); 
         out.println("No ah iniciado sesion <a href='entrar'> de clic aqui para loguearse </a>  ");}
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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

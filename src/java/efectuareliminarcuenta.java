/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * @author kazki
 */
@WebServlet(urlPatterns = {"/efectuareliminarcuenta"})
public class efectuareliminarcuenta extends HttpServlet {

Connection conexion;
    @Override
    public void init ()
    {try
    {Class.forName("com.mysql.jdbc.Driver");
    conexion=DriverManager.getConnection("jdbc:mysql://localhost/plataforma","root","");}
     catch(ClassNotFoundException man)
    {System.out.println("no hay manejador");}
     catch(SQLException base)
    {System.out.println("no hay conexion");}
    }
    @Override
    public void destroy ()
    {try
    {conexion.close();}
    catch (SQLException base)
    {System.out.println("no se puede cerrar");}
    }    /**
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
            out.println("<head>");
            HttpSession session = request.getSession(true);
            Object user = session.getAttribute("currentSessionUser");
            out.println("<title>Servlet efectuareliminarcuenta</title>");            
            out.println("</head>");
            out.println("<body >");
             try
            {
                
             String logear2 ="DELETE FROM `usuarios` WHERE `usuario`='"+user+"'";
            
                Statement a=conexion.createStatement();
             int fila=a.executeUpdate(logear2);    
    
    out.println("<h3 align='center'> Eliminado correctamente</h3>");
    session.setAttribute("currentSessionUser",null); 
          session.setAttribute("privilegio", null);
          session.setAttribute("premium", null);
      out.println("<form align='center' action='principal' method 'post'>");
            out.println("<td><input align='center' type='submit' value='Pagina principal'>");
            out.println("</from>"); 
            
                   }
      catch (SQLException base)
      { out.printf( base.getMessage()+"<p>A ocurrido un error con los dados proporcionados</p>");
      }
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

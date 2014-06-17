/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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

/**
 *
 * @author ruth
 */
@WebServlet(urlPatterns = {"/correo"})
public class correo extends HttpServlet {
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
    }
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
            out.println("<head>");
            out.println("<title>Servlet correo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form align='center' id='form1' name='form1' method='post' action='efectuarcorreo'>");
            try
             { out.println("<tr>");
            String logear2 ="select usuario,correo from usuarios";
            Statement a=conexion.createStatement();
            ResultSet fila = a.executeQuery(logear2); 
             out.println("<form align='center' id='form1' name='form1' method='post' action='efectuarcorreo'>");
           out.println("Nombre: <select  name='nombre' id='nombre'>  ");
           while(fila.next()){ 
               String fnombre = fila.getString("usuario");
             out.println("<option id='nombre' value='"+null+"'>   </option>\n");
             out.println("<option id='nombre' value='"+fila.getString("correo")+"'>"+fnombre+"</option>\n");
             }
           out.println("</select>  ");
             }
            catch (SQLException base)
      {out.printf( base.getMessage()+"<p>A ocurrido un error</p>");}
            try
             { out.println("<tr>");
            String logear2 ="select usuario,correo from usuarios";
            Statement a=conexion.createStatement();
            ResultSet fila = a.executeQuery(logear2); 
             out.println("<form align='center' id='form1' name='form1' method='post' action='efectuarcorreo'>");
           out.println("Nombre: <select  name='nombre1' id='nombre1'>  ");
           while(fila.next()){ 
               String fnombre = fila.getString("usuario");
             out.println("<option id='nombre1' value='"+null+"'>   </option>\n");
             out.println("<option id='nombre1' value='"+fila.getString("correo")+"'>"+fnombre+"</option>\n");
             }
           out.println("</select>  ");
             }
            catch (SQLException base)
      {out.printf( base.getMessage()+"<p>A ocurrido un error</p>");}
            try
             { out.println("<tr>");
            String logear2 ="select usuario,correo from usuarios";
            Statement a=conexion.createStatement();
            ResultSet fila = a.executeQuery(logear2); 
             out.println("<form align='center' id='form1' name='form1' method='post' action='efectuarcorreo'>");
           out.println("Nombre: <select  name='nombre2' id='nombre2'>  ");
           while(fila.next()){ 
               String fnombre = fila.getString("usuario");
             out.println("<option id='nombre2' value='"+null+"'>   </option>\n");
             out.println("<option id='nombre2' value='"+fila.getString("correo")+"'>"+fnombre+"</option>\n");
             }
           out.println("</select>  ");
             }
            catch (SQLException base)
      {out.printf( base.getMessage()+"<p>A ocurrido un error</p>");}
            out.println("Mensaje: <input align='center' width='195' type='text' name='correo' id='correo' /></td>\n" +
"      <td><input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' /></td>");
            out.println("</tr> ");
            out.println("<p></p>");
            out.println("</form>");
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

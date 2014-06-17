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
@WebServlet(name = "efectuarlogin", urlPatterns = {"/efectuarlogin"})
public class efectuarlogin extends HttpServlet {
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
            out.println("<title>Servlet efectuarlogin</title>");            
            out.println("</head>");
            out.println("<body  background=\"13.jpg\">");
           
               try
             {
                 String  usuario= request.getParameter("usuario");
            String  contrasena= request.getParameter("contrasena");
            String logear2 ="select usuario,contrasena,premium,Privilegio from usuarios where usuario='"+usuario+"' && contrasena='"+contrasena+"'";
            Statement a=conexion.createStatement();
             ResultSet fila=a.executeQuery(logear2);
      if(fila.next()==true && usuario.equals(fila.getString("usuario")) && contrasena.equals(fila.getString("contrasena"))){
    HttpSession session = request.getSession(true);	
    out.println("<h3 align='center'> logeado correctamente</h3>");
      out.println("<form align='center' action='principal' method 'post'>");
            out.println("<td><input align='center' type='submit' value='Entrar a la tienda'>");
            out.println("</from>");
       if(fila.getInt("premium")==2){
          String premium = "premium";
          session.setAttribute("premium",premium); 
          }
    else{
          String premium = null;
          session.setAttribute("premium",premium); 
      }
          
          session.setAttribute("currentSessionUser",usuario); 
          session.setAttribute("privilegio", fila.getString("privilegio"));
      }
    else{
    out.println("<h3 align='center'> Usuario o contraseña incorrectos</h3>");
      out.println("<input name='Volver' type='reset' value='Volver' onClick='history.back()'>");
      }
                   }
      catch (SQLException base)
      { out.printf( base.getMessage()+"<p>A ocurrido un error</p>");
      }
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

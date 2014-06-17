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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ruth
 */
@WebServlet(urlPatterns = {"/perfil"})
public class perfil extends HttpServlet {
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
            out.println("<title>Servlet perfil</title>");   
             HttpSession session = request.getSession(true);
         Object user = session.getAttribute("currentSessionUser");
         Object premium = session.getAttribute("premium");
            out.println("</head>");
            out.println("<body>");
            out.println(" <h1 class=\"headermain\">"+user+": Perfil público</h1>\n" +
"        <div class=\"headermenu\"><div class=\"logininfo\">Usted está ingresado como "+user);
          
           try
             {
            String logear2 ="select * from usuarios where usuario='"+user+"'";
            Statement a=conexion.createStatement();
             ResultSet fila=a.executeQuery(logear2);
      if(fila.next()==true){
    out.println("<table width='600' border='5' cellspacing='0' cellpadding='0'>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>Usuario </th>");
            out.println("<td width='477'>");
            out.println(fila.getString("usuario")+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Nombre </th>");
            out.println("<td width='477'>");
            out.println(fila.getString("nombre")+" "+ fila.getString("paterno")+" "+fila.getString("materno")+ "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>Privilegio </th>");
            out.println("<td width='477'>");
            if(fila.getString("privilegio").equals("1")){
            out.println("Dios");
            out.println("<form align='center' id='form1' name='form1' method='post' action='efectuarcambiorol'>");
            out.println("Cambiar: <select  name='nombre' id='nombre'>  ");
            out.println("<option id='nombre' value='1'> Dios </option>\n");
            out.println("<option id='nombre' value='2'> Administrador </option>\n");
            out.println("<option id='nombre' value='3'> Profesor </option>\n");
            out.println("<option id='nombre' value='4'> Estudiante </option>\n");
            out.println("</select> ");
            out.println("<input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' />");
            out.println("</form>");
            }
            else if(fila.getString("privilegio").equals("2")){
            out.println("Administrador");
            out.println("<form align='center' id='form1' name='form1' method='post' action='efectuarcambiorol'>");
            out.println("Cambiar: <select  name='nombre' id='nombre'>  ");
            out.println("<option id='nombre' value='2'> Administrador </option>\n");
            out.println("<option id='nombre' value='3'> Profesor </option>\n");
            out.println("<option id='nombre' value='4'> Estudiante </option>\n");
            out.println("</select> ");
            out.println("<input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' />");
            out.println("</form>");
            }
            else if(fila.getString("privilegio").equals("3")){
            out.println("Profesor/a");
            out.println("<form align='center' id='form1' name='form1' method='post' action='efectuarcambiorol'>");
            out.println("Cambiar: <select  name='nombre' id='nombre'>  ");
            out.println("<option id='nombre' value='3'> Profesor </option>\n");
            out.println("<option id='nombre' value='4'> Estudiante </option>\n");
            out.println("</select> ");
            out.println("<input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' />");
            out.println("</form>");
            }
            else if(fila.getString("privilegio").equals("4")){
            out.println("Alumno/a");
            }
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>Correo </th>");
            out.println("<td width='477'>");
            out.println(fila.getString("correo")+ "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>Premium</th>");
            out.println("<td width='477'>");
            if(fila.getString("premium").equals("1")){
            out.println("No es usuario premium");}
            else if(fila.getString("premium").equals("2")){
            out.println("Usuario Premium");
            }            
            out.println("</tr>");
            out.println("</table>"); 
            out.println("<form align='center' id='form1' name='form1' method='post' action='cambiodatos'>");
            String nombre1 = fila.getString("usuario");
            out.println("<input align='center' type='submit' name='aceptar' id='aceptar' value='Cambiar datos' />");
            out.println("</form>");   
             out.println("  <a align='left' href='eliminarcuenta'> Eliminar cuenta </a>");
          out.println("<form align='center' id='form1' name='form1' method='post' action='buscarusuario'>");
            out.println("Buscar Perfil: ");
            out.println("<input align='center' type='text' name='nombre' id='nombre' value='' />");
            out.println("<input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' />");
            out.println("</form>");          
      }
    else{
    out.println("<h3 align='center'> Usuario incorrecto</h3>");
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

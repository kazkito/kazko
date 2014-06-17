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

/**
 *
 * @author hp
 */
@WebServlet(name = "buscarexamen", urlPatterns = {"/buscarexamen"})
public class buscarexamen extends HttpServlet {
Connection conexion;
    @Override
	   public void init()
	{
        try
		{
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/plataforma","root" ,"");
		}
		catch(ClassNotFoundException man)
		{
			System.out.println("no hay manejador");
		}
		catch(SQLException base)
		{
           System.out.println("no hay conexion");
		}

	}
     
    @Override
	public void destroy()
	{
		try
		{
		conexion.close();
		}
		catch(SQLException base)
		{
         System.out.println("no se cierra");
		}
	}
    
    public String buscarRegistro(String buscarexamen)
	{
		String html = "";
		try
		{
       Statement sen = conexion.createStatement();
		ResultSet res = sen.executeQuery(buscarexamen);
		while (res.next())
		{
			
html += "<input name='pregunta' value='" + res.getString(1) + "'><br>";
html += "1.-<td><input type='radio' name='res1' value=''></td> ";              
html += "<input name='respuesta1'value='" + res.getString(2) + "'><br><br>";
html += "2.-<td><input type='radio' name='res2' value=''></td> ";
html += "<input name='respuesta2'value='" + res.getString(3) + "'><br><br>";
html += "3.-<td><input type='radio' name='res3' value=''></td> ";
html += "<input name='respuesta3'value='" + res.getString(4) + "'><br><br>";
html += "4.-<td><input type='radio' name='res4' value=''></td> ";
html += "<input name='respuesta4'value='" + res.getString(5) +"'><br><br>";

html += "<input name='solucion' value=''><br><br>";
html += "</form>";
		}
        res.close();
		sen.close();
		return html;
		}
		catch(SQLException base)
		{
           return base.getMessage();
		}
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
             String buscarexamen = "select * from examen ";
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet buscarexamen</title>");            
            out.println("</head>");
            out.println("<body bgcolor='black' text='yellow'>");
            
        out.println("<h4><form method='post' action='calificacion'>");
        out.println("<H2>" + buscarRegistro(buscarexamen) + "</H2><BR>");
        out.println("<td><input type='submit' name=' examen' value='tu calificacion es'></td>");
        out.println("</form></h4>");
            
            
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

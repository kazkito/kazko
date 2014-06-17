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
@WebServlet(name = "principal", urlPatterns = {"/principal"})
public class principal extends HttpServlet {
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
            out.println("<title>Servlet principal</title>");            
            out.println("</head>");
            out.println("<body>");
             HttpSession session = request.getSession(true);
         Object user = session.getAttribute("currentSessionUser");
            
            String stylo = "<style type=\"text/css\"> " +
"#menu {padding:0px; margin:0px auto; list-style-type:none; width:310px }" +
"#menu li { display:block; float:left; background-color:#1c1c1c; padding:5px; " +
"margin:0px auto; list-style-type:none; list-style:none; text-shadow:#00F; text-align:center; font-family:\"Arial Black\", Gadget, sans-serif; border-bottom:1px solid #000; border-left:1px solid #000; border-right:1px solid #0000; color:#FFF; border-top:1px solid #000;" +
"-webkit-transition: -webkit-box-shadow:0.6s ease-out;" +
"-moz-transition:-moz-box-shadow: .6s ease-out; " +
"-o-transition: box-shadow:0.6s ease-out;}" +
"#menu a:link { margin: 0; padding:0px; color: #0FF; border-right: 1px solid #d1e3db; text-decoration:none; } \n" +
"#menu li:hover{ background-color:#FFF;" +
"-moz-box-shadow:0px 0px 15px #0099ff;" +
"-webkit-box-shadow:0px 0px 15px #0099ff;" +
"    box-shadow: 0px 0px 15px #0099ff;}" +
"    #menu a:hover + ul a { color:#00C;}</style>";
            session.setAttribute("style",stylo); 
         if(user == null){
         
        request.getRequestDispatcher("inicioinvitado").forward(request, response);
        }
        else{
         request.getRequestDispatcher("inicio").forward(request, response);
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

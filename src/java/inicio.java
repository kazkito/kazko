/*
 * To change this template, choose Tools | Templates
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
 * @author hp
 */
@WebServlet(name = "inicio", urlPatterns = {"/inicio"})
public class inicio extends HttpServlet {

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
           
             HttpSession session = request.getSession(true);
            Object user = session.getAttribute("currentSessionUser");
         Object style = session.getAttribute("style");
            out.println("<head> "+style+" ");
            out.println("<title>Servlet inicio</title>"); 
             if(user != null){
            out.print("Bienvenido "+user);
            out.print("<a align='left' href='Desloguear'> Desloguear </a>");
            }
            else { }
            out.println("</head>");
            out.println("<body  background=\"1.jpg\">");
             
         if(user != null){
 out.println(" <div> \n" +
"<ul id=\"menu\" >\n" +
"<li><a href=\"index.jsp\" >Inicio </a></li>\n" +
"<li><a href=\"perfil\" >Perfil </a></li>\n" +
"<li><a href=\"perfil\" >Usuarios </a></li> \n" +
"<li><a href=\"correo\" >Usuarios</a></li>\n" +
"<li><a href=\"Desloguear.php\">Salir</a> </li>\n" +
"</ul></div>"); 
         
         out.println("<p><p><p><p>Usted no es usuario premium, <a href='premium'>de clic aqui "+
                 "para serlo</a>");}
         else{out.println("No ah iniciado sesion <a href='entrar'> de clic aqui para loguearse </a>  ");}
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

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

/**
 *
 * @author hp
 */
@WebServlet(name = "entrar", urlPatterns = {"/entrar"})
public class entrar extends HttpServlet {

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
            out.println("<head> <style type=\"text/css\"> \n" +
"#menu {padding:0px; margin:0px auto; list-style-type:none; width:412px }\n" +
"#menu li { display:block; float:left; background-color:#1c1c1c; padding:5px; \n" +
"margin:0px auto; list-style-type:none; list-style:none; text-shadow:#00F; text-align:center; font-family:\"Arial Black\", Gadget, sans-serif; border-bottom:1px solid #000; border-left:1px solid #000; border-right:1px solid #0000; color:#FFF; border-top:1px solid #000;\n" +
"-webkit-transition: -webkit-box-shadow:0.6s ease-out;\n" +
"-moz-transition:-moz-box-shadow: .6s ease-out; \n" +
"-o-transition: box-shadow:0.6s ease-out;}\n" +
"#menu a:link { margin: 0; padding:0px; color: #0FF; border-right: 1px solid #d1e3db; text-decoration:none; } \n" +
"#menu li:hover{ background-color:#FFF;\n" +
"-moz-box-shadow:0px 0px 15px #0099ff;\n" +
"-webkit-box-shadow:0px 0px 15px #0099ff;\n" +
"    box-shadow: 0px 0px 15px #0099ff;}\n" +
"    #menu a:hover + ul a { color:#00C;}</style>"
                    + "<style type=\"text/css\">\n" +
"  body {\n" +
"background-image:1.jpg" +
"background-attachment:fixed;\n" +
"background-position:top center;\n" +
"background-repeat:no-repeat}\n" +
"}\n" +
"\n" +
"#contenedor{\n" +
"margin-left:30px;\n" +
"margin-top:0px;\n" +
"padding:0 0 0 0;\n" +
"width:auto;\n" +
"position:absolute;\n" +
"}\n" +
".divcontenido{\n" +
"    float:left;\n" +
"    font-family:Verdana, Arial, Helvetica, sans-serif;\n" +
"    font-size:9px;\n" +
"    padding:10px;\n" +
"    border-color:#CCCCCC;\n" +
"    border-style:groove;\n" +
"    border-width:10px;\n" +
"    width:300px;\n" +
"    text-align:left;\n" +
"}\n" +
".divcontenido{\n" +
"    float:left;\n" +
"    font-family:Arial;\n" +
"    font-size:15px;\n" +
"    padding:10px;\n" +
"    border-color:#CCCCCC;\n" +
"    border-style:groove;\n" +
"    border-width:10px;\n" +
"    width:350px;\n" +
"    text-align:left;\n" +
"    margin-left:25px;\n" +
"}\n" +
"</style>");
            
             out.println(" <div> \n" +
"<ul id=\"menu\" >\n" +
"<li><a href=\"index.jsp\" >Inicio </a></li>\n" +
"<li><a href=\"entrar\" >Login/registro </a></li>\n" +
"<li><a href=\"perfil\" >Usuarios </a></li> \n" +
"<li><a href=\"Cursos\" >Chat</a></li>\n" +
"</ul></div><p></p>");
            out.println("<title>Servlet entrar</title>");            
            out.println("</head>");
            out.println("<body align='center'  background=\"14.jpg\">");
            out.println("<div id='contenedor'> <div class='divcontenido'> <h1 align='center'>Logearse</h1>");
            out.println("<h3 align='center'>Para ingresar a la tienda ingrese sus datos</h3>");
            out.println(" <form  id='form1' name='form1' method='post' action='efectuarlogin'>");
            out.println("<table align='center' width='600' border='0' cellspacing='0' cellpadding='0'>");
            out.println("<tr>");
            out.println("<th width='123' scope='row'>Usuario</th>");
            out.println("<td width='477'>");
            out.println("<input width='477' type='text' name='usuario' id='usuario' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Contraseña</th>");
            out.println("<td><input  width='477'type='text' name='contrasena' id='contrasena' /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<p><input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' />");
            out.println("<input name='Volver' type='reset' value='Volver' onClick='history.back()'> </form>");
           
            out.println("<form align='center' id='form2' name='form2' method='post' action='password'>");
            out.println("<a align='center' href='password'>¿Has olvidado tu contraseña?</a></form></div>");
            out.println("<div class='divcontenido'><h1 align='center'>Registrarse</h1>");
            out.println("<h3 align='center'>Ingrese los datos siguientes: </h3>");
            
            out.println("<form  id='form1' name='form1' method='post' action='efectuarregistro'>");
            out.println("<table  align='center' width='600' border='0' cellspacing='0' cellpadding='0'>");
            out.println("<tr>");
            out.println("<th width='164' scope='row'>Nombre:</th>");
            out.println("<td  id='nombre' width='436'><input  width='436'type='text' name='nombre' id='nombre' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Apellido paterno:</th>");
            out.println("<td id='paterno'><input  width='436'type='text' name='paterno' id='paterno' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Apellido materno:</th>");
            out.println("<td  id='materno'><input  width='436'type='text' name='materno' id='materno' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println(" <th scope='row'>Usuario:</th>");
            out.println("<td id='usuario'><input  width='436'type='text' name='usuario' id='usuario' />;</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Contraseña:</th>");
            out.println("<td id='contrasena'><input  width='436'type='text' name='contrasena' id='contrasena' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Confirmar contraseña:</th>");
            out.println("<td id='contrasena2'><input  width='436'type='text' name='contrasena2' id='contrasena2' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Fecha de nacimiento AAAA/MM/DD:</th>");
            out.println("<td id='nacimiento'><input  width='436'type='text' name='nacimiento' id='nacimiento' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Correo electronico:</th>");
            out.println("<td id='correo'><input  width='436'type='text' name='correo' id='correo' /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th scope='row'>Numero de tarjeta de credito:</th>");
            out.println("<td id='correo'><input  width='436'type='text' name='tarjeta' id='correo' /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<p><input align='center' type='submit' name='aceptar' id='aceptar' value='Aceptar' />");
            out.println("</form>");
            out.println("<form align='center' id='form2' name='form2' method='post' action='principal'>");
            out.println("<input type='submit' name='Volver' id='Volver' value='Volver'/></p>");
            out.println("</form></div></div>");
            
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;//Comandos basicos de Java//
import javax.mail.Message;//Modificar el mensaje//
import javax.mail.Session;//Inisiar sesion en el correo//
import javax.mail.Transport;//Transportar datos//
import javax.mail.internet.InternetAddress; //Entrar a internet//
import javax.mail.internet.MimeMessage; //Enviar mensaje 

/**
 *
 * @author hp
 */
@WebServlet(name = "efectuarregistro", urlPatterns = {"/efectuarregistro"})
public class efectuarregistro extends HttpServlet {
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
    public String insertar(String agregarusuarios)   
    {String html="";
    try
    {Statement a=conexion.createStatement();
          int fila=a.executeUpdate(agregarusuarios);
          return html;
    }
      catch (SQLException base)
      { return base.getMessage()+"<p>A tenido un error en el registro, por favor revice los dados proporcionados</p>";
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
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
              String  nombre= request.getParameter("nombre");
           final String  paterno= request.getParameter("paterno");
            String  materno= request.getParameter("materno");
            String  usuario= request.getParameter("usuario");
            String  contrasena= request.getParameter("contrasena");
            String  nacimiento= request.getParameter("nacimiento");
            String  correo= request.getParameter("correo");
            String  contrasena2= request.getParameter("contrasena2");
            String  tarjeta= request.getParameter("tarjeta");
            
            if(nombre != null && paterno != null && materno != null && usuario != null && contrasena != null && nacimiento != null && 
                    correo != null && contrasena2 != null && tarjeta != null ){
             try {
            
            
            Properties props = new Properties();
            props.setProperty("mail.smtp.host","smtp.gmail.com");//Servidor del correo//
            props.setProperty("mail.smtp.starttls.enable","true");
            props.setProperty("mail.smtp.port","25");//El puerto cual se conectara//
            props.setProperty("mail.smtp.user","jajaviereduardo@gmail.com" );
            props.setProperty("mail.smtp.auth","true" );
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jajaviereduardo@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject("Confirmacion de registro");
            message.setText("Bienvenido a la plataforma Blender"+""+" Su usuario es "+usuario+
                    ""+" Su contraseña es "+contrasena+""+" El pago se ah enviado a su tarjeta de credito. Disfruta la plataforma.");
            Transport t = session.getTransport("smtp");
            t.connect("jajaviereduardo@gmail.com","lalalafucklalala");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            
            
        }
        catch(Exception e){
        e.printStackTrace();
        }
            String agregarusuarios = "insert into usuarios(Privilegio,nombre,paterno,materno,usuario,contrasena,nacimiento,correo)"
                    + " values ('"+2+"','"+nombre+"','"+paterno+"','"+materno+"','"+usuario+"','"+contrasena2+"','"+nacimiento+"','"+correo+"')";
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet efectuarregistro</title>");            
            out.println("</head>");
            out.println("<body align='center'  background=\"14.jpg\"> ");
            if(contrasena2 == null ? contrasena == null : contrasena2.equals(contrasena)) {
            out.println("<h3 align='center'> Registrado correctamente.</h3>");
            out.println("<form action='principal' method 'post'>");
            out.println("<td><input type='submit' value='Pagina principal'>");
            out.println("</from>");
            out.println("<h2>"+insertar(agregarusuarios)+"<h2>");
            out.println("");
            }
            else{
            out.println("<h3 align='center'>Las contraseñas no coinciden</h3> ");
            out.println("<form  action='entrar' method 'post'>");
            out.println("<td><input type='submit' value='Regresar'>");
             
            
            out.println("</from>");
            }}out.println("</body>");
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

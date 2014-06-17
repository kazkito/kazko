/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ruth
 */
@WebServlet(urlPatterns = {"/efectuarcorreo"})
public class efectuarcorreo extends HttpServlet {

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
            out.println("<title>Servlet efectuarcorreo</title>");            
            out.println("</head>");
            out.println("<body>");
            try {
                 HttpSession sesion = request.getSession(true);
             Object user = sesion.getAttribute("currentSessionUser");
         String  nombre = request.getParameter("nombre");
          String  nombre1 = request.getParameter("nombre1"); 
          String  nombre2 = request.getParameter("nombre2");
           String  correo = request.getParameter("correo");
          
            Properties props = new Properties();
            props.setProperty("mail.smtp.host","smtp.gmail.com");//Servidor del correo//
            props.setProperty("mail.smtp.starttls.enable","true");
            props.setProperty("mail.smtp.port","25");//El puerto cual se conectara//
            props.setProperty("mail.smtp.user","jajaviereduardo@gmail.com" );
            props.setProperty("mail.smtp.auth","true" );
            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jajaviereduardo@gmail.com"));
            
            if(nombre == null && nombre1 != null && nombre2 !=null){
            message.addRecipients(Message.RecipientType.TO, new InternetAddress[] {new InternetAddress(nombre1,nombre2)});}
            else if(nombre != null && nombre1 == null && nombre2 !=null){
            message.addRecipients(Message.RecipientType.TO, new InternetAddress[] {new InternetAddress(nombre,nombre2)});}
            else if(nombre != null && nombre1 != null && nombre2 ==null){
            message.addRecipients(Message.RecipientType.TO, new InternetAddress[] {new InternetAddress(nombre,nombre1)});}
            else if(nombre == null && nombre1 == null && nombre2 !=null){
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(nombre2));}
            else if(nombre == null && nombre1 != null && nombre2 ==null){
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(nombre1));}
            else if(nombre != null && nombre1 == null && nombre2 !=null){
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(nombre));}
            message.setSubject("Mensaje privado de "+user);
            message.setText("El usuario "+user+" te ah enviado un mensaje privado : '"+correo+"'   Utilize la seccion"+
                    " de mensaje de la plataforma para comunicarse con el.");
            Transport t = session.getTransport("smtp");
            t.connect("jajaviereduardo@gmail.com","lalalafucklalala");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            
        }
        catch(Exception e){
        e.printStackTrace();
        }
            out.println("Enviado!</body>");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Properties;//Comandos basicos de Java//
import javax.mail.Message;//Modificar el mensaje//
import javax.mail.Session;//Inisiar sesion en el correo//
import javax.mail.Transport;//Transportar datos//
import javax.mail.internet.InternetAddress; //Entrar a internet//
import javax.mail.internet.MimeMessage; //Enviar mensaje por internet//
/**
 *
 * @author ruth
 */
public class confirmaregistro {
    
    public static void main(String[] args) {
       
        // TODO code application logic here
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
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("narutoxgaaraxsasuke@hotmail.com"));
            message.setSubject("Recibo de pago.");
            message.setText("Tu factura numero: 525 "+" es de "+" $1000");
            Transport t = session.getTransport("smtp");
            t.connect("jajaviereduardo@gmail.com","lalalafucklalala");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            
            
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
}



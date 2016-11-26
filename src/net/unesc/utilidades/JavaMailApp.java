package net.unesc.utilidades;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import net.unesc.entidades.Evento;

public class JavaMailApp
{   
    public void EnviarEmail(Evento evento){
          
          String textoEmail;
          Properties props = new Properties();

          textoEmail="Lembrete de evento.\n\n"+
            "Evento: "+evento.getDescricao()+".\n\n"+      
            "Esta mensagem foi enviada por um sistema automatico, por favor não responda!";
          
          /** Parâmetros de conexão com servidor Gmail */
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.port", "465");

          Session session = Session.getDefaultInstance(props,
                      new javax.mail.Authenticator() {
                           protected PasswordAuthentication getPasswordAuthentication() 
                           {
                                 return new PasswordAuthentication("rafael.unesc.teste@gmail.com", "@rafaeltestes");
                           }
                      });

          /** Ativa Debug para sessão */
          //session.setDebug(true);

          try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("rafael.unesc.teste@gmail.com")); //Remetente

                Address[] toUser = InternetAddress //Destinatário(s)
                           .parse(evento.getEmail());  

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Lembrete de evento");//Assunto
                message.setText(textoEmail);
                /**Método para enviar a mensagem criada*/
                Transport.send(message);

           } catch (MessagingException e) {
                throw new RuntimeException(e);
          }
    }
}
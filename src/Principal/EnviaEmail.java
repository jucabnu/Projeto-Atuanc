/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author Juliano
 */

import DAO.DAOUsuario;
import DTO.Rnc;
import DTO.Usuario;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
 
public class EnviaEmail{
    
    public static void Aviso(Usuario usuario){
    
        Properties props = new Properties();            
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication() 
                 {
                    return new PasswordAuthentication("atuanctcc@gmail.com", "hydF4$5Ffe5f6*8&5edgfd_45Dfgd$");
                 }
            });
        session.setDebug(true);
 
            
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("atuanctcc@gmail.com")); //Remetente (sempre o mesmo)

            //pegar todos destinatários cadastrados
            ArrayList<Usuario> usuarios = DAOUsuario.getUsuarios();                  
            String destinos = "";       
            destinos = destinos + usuario.getEmausu();
            /*
            for(Usuario u : usuarios){
                if(!u.getEmausu().equals("")){
                    destinos = destinos + u.getEmausu() + ", ";
                }
            }
            */

            Address[] toUser = InternetAddress 
                         .parse(destinos);  

              message.setRecipients(Message.RecipientType.TO, toUser);
              String assunto = "Tentativa de acesso bloqueado na sua conta";

              String corpo;
              corpo = "Tentativa de acesso bloqueada na sua conta." 
                      + "\n" + 
                      "Recomenda-se alterar a senha!"
                      + "\n" +
                      "Não responder. Mensagem enviada por robô";

              message.setSubject(assunto);
              message.setText(corpo);
              Transport.send(message);
              System.out.println("Feito!!!");
         } catch (MessagingException e) {
             JOptionPane.showMessageDialog(null, "Servidor de e-mail indisponível");
              throw new RuntimeException(e);
        }
    }
    
    
      public static void Enviar(Rnc rnc, String tipo) {
          
          //tipo: inclusão / alteração         
          
            Properties props = new Properties();
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
                                   return new PasswordAuthentication("atuanctcc@gmail.com", "hydF4$5Ffe5f6*8&5edgfd_45Dfgd$");
                             }
                        });
 
            /** Ativa Debug para sessão */
            session.setDebug(true);
 
            
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("atuanctcc@gmail.com")); //Remetente (sempre o mesmo)
 
                  //pegar todos destinatários cadastrados
                  ArrayList<Usuario> usuarios = DAOUsuario.getUsuarios();                  
                  String destinos = "";                  
                  for(Usuario u : usuarios){
                      if(!u.getEmausu().equals("")){
                        destinos = destinos + u.getEmausu() + ", ";
                        
                      }
                  }
                                    
                  Address[] toUser = InternetAddress 
                             .parse(destinos);  
                  
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  String assunto = "RNC " + tipo;
                  
                  String corpo;
                  corpo = "RNC foi " + tipo
                          + " por " + DAOUsuario.getUsuarioPeloCod(rnc.getAltusu()).getNomusu() + "\n"
                          + "\n" +
                          "Número da FAL: " + rnc.getNumfal() + "\n" +
                          "Número da NF: " + rnc.getNumnfe() + "\n" +
                          "Quantidade: " + rnc.getQtdrnc() + "\n" 
                          + "\n" +
                          "Área: " + rnc.getAreind() + "\n" +                          
                          "Responsável: " + rnc.getResind() + "\n" 
                          + "\n"
                          + "\n" +
                          "Não responder. Mensagem enviada por robô";
                                                    
                  message.setSubject(assunto);
                  message.setText(corpo);
                  
                  //message.setFileName(string);
                  
                  Transport.send(message);
 
                  System.out.println("Feito!!!");
 
             } catch (MessagingException e) {
                 JOptionPane.showMessageDialog(null, "Servidor de e-mail indisponível");
                  throw new RuntimeException(e);
            }
      }
}
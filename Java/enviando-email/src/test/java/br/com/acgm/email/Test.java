package br.com.acgm.email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test {
	
	private String user = "testeenvioemailjava123@gmail.com";
	private String pass = "rqubadpnyrnaundb";
	
	@org.junit.Test
	public void testeEmail() {
		
		//olhe as configuracoes smtp do seu email
		
		try {
		
				Properties properties = new Properties();
		
				properties.put("mail.smtp.auth","true"); //autorizacao
				properties.put("mail.smtp.starttls","true"); //autenticacao
				properties.put("mail.smtp.host","smtp.gmail.com"); //servidor gmail
				properties.put("mail.smtp.port","465"); //porta do servidor
				properties.put("mail.smtp.socketFactory.port","465"); //porta do socket
				properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //classe socket de conexao ao smtp
				
				Session session = Session.getInstance(properties, new Authenticator() {
					
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						
						return new PasswordAuthentication(user,pass);
					}
				});
				
				Address[] toUser = InternetAddress.parse("testeenvioemailjava123@gmail.com, ant.marinho@outlook.com");
				
				Message msg = new MimeMessage(session);
				
				msg.setFrom(new InternetAddress(user)); //quem esta enviando
				msg.setRecipients(Message.RecipientType.TO,toUser); //email de destino
				msg.setSubject("email enviado por jmail"); // assunto do email
				msg.setText("vc acaba de receber email enviado com java"); //texto do email
				
				Transport.send(msg);
				
		}
		catch (Exception e){
			
			e.printStackTrace();
		}
		
		
	}

}

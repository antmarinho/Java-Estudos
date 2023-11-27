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

public class ObjetoEnviarEmail {
	
	private String user = "ant.marinho145@gmail.com";
	private String pass = "ozwugcauaktswrcp";
	
	private String listaDestinatario;
	private String remetente;
	private String assuntoEmail;
	private String textoEmail;
	
	public ObjetoEnviarEmail(String listaDestinatario, String remetente, String assuntoEmail, String textoEmail) {
		
		this.listaDestinatario = listaDestinatario;
		this.remetente = remetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}
	
	public void enviarEmail(boolean envioHtml) {
		
		//olhe as configuracoes smtp do seu email
		
		try {
				
				Properties properties = new Properties();
				
				properties.put("mail.smtp.ssl.trust", "*");
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
						
				Address[] toUser = InternetAddress.parse(listaDestinatario);
						
				Message msg = new MimeMessage(session);
						
				msg.setFrom(new InternetAddress(user,remetente)); //quem esta enviando
				msg.setRecipients(Message.RecipientType.TO,toUser); //email de destino
				msg.setSubject(assuntoEmail); // assunto do email
				
				if(envioHtml) {
					
					msg.setContent(textoEmail,"text/html; charset= utf-8");
				}
				else
					msg.setText(textoEmail); //texto do email
						
				
				Transport.send(msg);
						
		}
		catch (Exception e){
					
			e.printStackTrace();
		}
				
				
	}

}

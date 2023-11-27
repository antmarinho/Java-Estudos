package br.com.acgm.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
	
	
	//metodo simula o pdf ou qualquer arquivo pra ser enviado por anexo
	private FileInputStream simuladorPDF() throws IOException, DocumentException {
		
		Document documento = new Document();
		
		File file = new File("documento.pdf");
		
		file.createNewFile();
		
		PdfWriter.getInstance(documento, new FileOutputStream(file));
		
		documento.open();
		documento.add(new Paragraph("conteudo do pdf"));
		documento.close();
		
		//retorna um pdf com o texto do paragrafo de exemplo
		return new FileInputStream(file);
	}
	
	protected Properties propGmail() {
		
		//olhe as configuracoes smtp do seu email
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth","true"); //autorizacao
		properties.put("mail.smtp.starttls","true"); //autenticacao
		properties.put("mail.smtp.host","smtp.gmail.com"); //servidor gmail
		properties.put("mail.smtp.port","465"); //porta do servidor
		properties.put("mail.smtp.socketFactory.port","465"); //porta do socket
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory"); //classe socket de conexao ao smtp
		
		return properties;
		
	}
	
	protected Session session() {
		
		Session session = Session.getInstance(propGmail(), new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
						
				return new PasswordAuthentication(user,pass);
			}
		});
		
		return session;
	}
	
	// envia email true e com html e false so texto
	public void enviarEmailAnexo(boolean envioHtml) {
		
		
		try {	
						
				Address[] toUser = InternetAddress.parse(listaDestinatario);
						
				Message msg = new MimeMessage(session());
						
				msg.setFrom(new InternetAddress(user,remetente)); //quem esta enviando
				msg.setRecipients(Message.RecipientType.TO,toUser); //email de destino
				msg.setSubject(assuntoEmail); // assunto do email
				
				//parte 1 do email texto e descricaio do email
				
				MimeBodyPart corpoEmail = new MimeBodyPart();
				
				if(envioHtml) {
					
					corpoEmail.setContent(textoEmail,"text/html; charset= utf-8");
				}
				else
					corpoEmail.setText(textoEmail); //texto do email
					
				List<FileInputStream> arquivos = new ArrayList<>();
				
				arquivos.add(simuladorPDF());
				arquivos.add(simuladorPDF());
				arquivos.add(simuladorPDF());
				
				Multipart mp = new MimeMultipart();//muitos anexos
				
				mp.addBodyPart(corpoEmail); // muitos anexos
				
				 //muitos anexos
				int index = 0;
				for (FileInputStream fileInputStream : arquivos) {
					
					//parte 2 do email sao o anexos
					MimeBodyPart anexoEmail = new MimeBodyPart();
					
					anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(fileInputStream, "application/pdf")));
					anexoEmail.setFileName("anexoemail" + index+".pdf");
					
					mp.addBodyPart(anexoEmail);
					
					index++;
					
				}
				
				//parte 2 do email sao o anexos
			//	MimeBodyPart anexoEmail = new MimeBodyPart();
				
			//	anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(simuladorPDF(), "application/pdf")));
			//	anexoEmail.setFileName("anexoemail.pdf");
				
				//Multipart mp = new MimeMultipart();
				
				//mp.addBodyPart(corpoEmail);
				//mp.addBodyPart(anexoEmail);
				
				msg.setContent(mp);
				
				Transport.send(msg);
						
		}
		catch (Exception e){
					
			e.printStackTrace();
		}
				
	}
	
	// envia email true e com html e false so texto
	public void enviarEmail(boolean envioHtml) {
		
		try {
						
						
				Address[] toUser = InternetAddress.parse(listaDestinatario);
						
				Message msg = new MimeMessage(session());
						
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

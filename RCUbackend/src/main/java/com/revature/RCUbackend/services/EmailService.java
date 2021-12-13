//package com.revature.RCUbackend.services;
//
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Properties;
//
////import javax.mail.Authenticator;
////import javax.mail.Message;
////import javax.mail.Multipart;
////import javax.mail.PasswordAuthentication;
////import javax.mail.Session;
////import javax.mail.Transport;
////import javax.mail.internet.InternetAddress;
////import javax.mail.internet.MimeBodyPart;
////import javax.mail.internet.MimeMessage;
////import javax.mail.internet.MimeMultipart;
//
//@Service
//@Component
//public class EmailService {
//
//	private String username ="erickjohnson1980@gmail.com";
//
//	private String password = "Excaliber420";
//	public void resetPass(int id)
//	{
//
//	}
//
//	public void alert(int id)
//	{
//		System.out.println(username+" :  "+password );
//		Properties prop = new Properties();
//		prop.put("mail.smtp.auth", true);
//		prop.put("mail.smtp.starttls.enable", "true");
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//		prop.put("mail.smtp.port", "587");
//		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//
////		Session session = Session.getInstance(prop, new Authenticator() {
////		    @Override
////		    protected PasswordAuthentication getPasswordAuthentication() {
////
////		        return new PasswordAuthentication(username, password);
////		    }
////		});
////		try {
////		Message message = new MimeMessage(session);
////		message.setFrom(new InternetAddress("erickjohnson1980@gmail.com"));
////		message.setRecipients(
////		  Message.RecipientType.TO, InternetAddress.parse("erick.johnson@revature.net"));
////		message.setSubject("Mail Subject");
////
////		String msg = "This is my first email using JavaMailer";
////
////		MimeBodyPart mimeBodyPart = new MimeBodyPart();
////		mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
////
////		Multipart multipart = new MimeMultipart();
////		multipart.addBodyPart(mimeBodyPart);
////
////		message.setContent(multipart);
////
////		Transport.send(message);
////		}
////		catch(Exception e)
////		{
////			System.out.println("Error sending email alert\n" + e.toString());
////		}
//}
//
//}

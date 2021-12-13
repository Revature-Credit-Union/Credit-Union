package com.revature.RCUbackend.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.revature.RCUbackend.models.User;
import com.revature.RCUbackend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
	UserService Uservice;
	@Autowired
	private Environment env;

	private String smtpName = "erickjohnson1980@gmail.com";
	private String smtpPass = "Excaliber666";

	public EmailService() {
	}


	public void alert(int id , String subject , String msg)
	{
		User user = Uservice.getUser(id);
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		    	
		        return new PasswordAuthentication(smtpName, smtpPass);
		    }
		});
		try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(smtpName));
		message.setRecipients(
		  Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
		message.setSubject(subject);

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);

		message.setContent(multipart);

		Transport.send(message);
		}
		catch(Exception e)
		{
			System.out.println("Error sending email alert\n" + e.toString());
		}
	}

}

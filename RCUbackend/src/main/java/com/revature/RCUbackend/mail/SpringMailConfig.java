package com.revature.RCUbackend.mail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class SpringMailConfig {

	@Bean
	public JavaMailSender javaMailSender() {
	    JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
	    javaMailSenderImpl.setHost("smtp.office365.com");
	    javaMailSenderImpl.setPort(587);
	    
	    javaMailSenderImpl.setUsername("RCU_test@hotmail.com");
	    javaMailSenderImpl.setPassword(System.getenv("RCU_mail_pass"));
	    
	    Properties props = javaMailSenderImpl.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return javaMailSenderImpl;
	}
}

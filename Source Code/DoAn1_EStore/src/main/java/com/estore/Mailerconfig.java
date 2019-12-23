package com.estore;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class Mailerconfig {
	@Bean
	public JavaMailSender getJavamailSender() {
		JavaMailSenderImpl mailer = new JavaMailSenderImpl();
		
		mailer.setHost("smtp.gmail.com");
		mailer.setPort(587);
		mailer.setUsername("tvtuan1306@gmail.com");
		mailer.setPassword("dongha2525123");
		mailer.setDefaultEncoding("utf-8");
		mailer.setProtocol("smtp");
		
		Properties props = mailer.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		
		return mailer;
	}
}

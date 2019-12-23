package com.estore.service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Gui mail voi JavaMailSender
 */
@Service
public class MailerService {
	@Autowired
	JavaMailSender mailSender;
	
	public void send(String to, String subject, String body, String...others) {
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			if(others.length > 0 && others[0] != null && others[0].length() > 0) {
				helper.setFrom(others[0], others[0]);
				helper.setReplyTo(others[0], others[0]);
			}
			else {
				helper.setFrom("master@gmail.com", "Web Master");
				helper.setReplyTo("master@gmail.com", "Web Master");
			}
			
			if(others.length > 1 && others[1] != null && others[1].length() > 0) {
				helper.setCc(others[1]);
			}
			
			if(others.length > 2 && others[2] != null && others[2].length() > 0) {
				helper.setBcc(others[2]);
			}
			
			if(others.length > 3 && others[3] != null && others[3].length() > 0) {
				String[] paths = others[3].trim().split("[,;]+");
				for(String path : paths) {
					File file = new File(path);
					helper.addAttachment(file.getName(), file);
				}
			}
			
			mailSender.send(mail);
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

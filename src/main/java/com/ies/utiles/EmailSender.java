package com.ies.utiles;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void mailSender(String subject,String body,String to,File file){
		
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			
			MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true);
			
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			helper.addAttachment("CitizensReport", file);
			mailSender.send(mimeMessage);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

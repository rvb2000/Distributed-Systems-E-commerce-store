package com.emailService;



import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.emailService.model.EmailWithAttachment;
import com.emailService.model.MultiRecipientEmail;
import com.emailService.model.SimpleEmail;

@Service
public class emailServiceController {

	@Autowired
	private JavaMailSender mailSender;
	
	
	
	public void sendSingleMail(SimpleEmail mail) throws MessagingException {
		
		//try {
			MimeMessage message = mailSender.createMimeMessage();  
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			
			helper.setFrom(mail.getSender());
			helper.setTo(mail.getRecipient());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getText(),true);
			//helper.addAttachment("myFileName", Datasource);
			
			mailSender.send(message);
//		}catch(MessagingException e) {
//			e.printStackTrace();
//		}
		return;
	}
	
public void sendMultiRecipientMail(MultiRecipientEmail mail) throws MessagingException {
		
		//try {
		String[] recipients = mail.getRecipients();
		for(String recipient : recipients) {
			MimeMessage message = mailSender.createMimeMessage();  
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			
			helper.setFrom(mail.getSender());
			helper.setTo(recipient);
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getText(),true);
			//helper.addAttachment("myFileName", Datasource);
			
			mailSender.send(message);
		}
			
//		}catch(MessagingException e) {
//			e.printStackTrace();
//		}
		return;
	}
	


public void sendSingleMailWithAttachment (EmailWithAttachment mail) throws MessagingException {
	
	//try {
		MimeMessage message = mailSender.createMimeMessage();  
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		helper.setFrom(mail.getSender());
		helper.setTo(mail.getRecipient());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getText(),true);
		
		File file = new File(mail.getFileUri());
		FileSystemResource fileResource = new FileSystemResource(file);  
		helper.addAttachment(mail.getFileName(), fileResource);
		
		mailSender.send(message);
//	}catch(MessagingException e) {
//		e.printStackTrace();
//	}
	return;
}

}

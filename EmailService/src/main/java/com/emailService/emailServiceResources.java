package com.emailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailService.model.EmailWithAttachment;
import com.emailService.model.MultiRecipientEmail;
import com.emailService.model.SimpleEmail;

@RestController
@RequestMapping("/email")
public class emailServiceResources {

	
	@Autowired
	private emailServiceController emailSender;
	
	
	
	
	@PostMapping("/notification")
	public String sendEmail(@RequestBody SimpleEmail simpleEmail) {
		try {
		emailSender.sendSingleMail(simpleEmail);
		return "message Sent";
		}catch(Exception e) {
			return e.toString();
		}
	}
	
	@PostMapping("/notification/group")
	public String sendMultiRecipientEmail(@RequestBody MultiRecipientEmail multiRecipientMail) {
		try {
		emailSender.sendMultiRecipientMail(multiRecipientMail);
		return "message Sent";
		}catch(Exception e) {
			return e.toString();
		}
	}
	
	@PostMapping("/notification/attachment")
	public String sendEmailWithAttchment(@RequestBody EmailWithAttachment email) {
		try {
		emailSender.sendSingleMailWithAttachment(email);
		return "message Sent";
		}catch(Exception e) {
			return e.toString();
		}
	}
}

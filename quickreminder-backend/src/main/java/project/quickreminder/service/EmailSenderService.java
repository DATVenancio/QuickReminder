package project.quickreminder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import project.quickreminder.model.TemporaryCode;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;
	private final String SENDEREMAIL = "quickreminderoficial@gmail.com";
	
	public void sendMail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(SENDEREMAIL);
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
		
	}

	public void sendTemporaryCode(TemporaryCode temporaryCode) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(SENDEREMAIL);
		message.setTo(temporaryCode.getEmail());
		message.setSubject("Enter this code in our site to check all our reminders!");
		message.setText(temporaryCode.getCode());
		
		mailSender.send(message);
	}
}

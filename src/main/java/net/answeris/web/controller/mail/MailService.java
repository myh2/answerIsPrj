package net.answeris.web.controller.mail;

import javax.mail.MessagingException; 
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	@Autowired
	private JavaMailSenderImpl mailSender;

	public void sendMail(String from, String to, String subject, String text) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		/*JavaMailSenderImpl sender = new JavaMailSenderImpl();
		MimeMessage mimeMessage = mailSender.createMimeMessage();*/
			
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		
		mailSender.send(message);
	}
	

	public void sendMimeMail(String from, String to, String subject, String text/*, String Attachment*/) throws MessagingException {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text, true);
		
		
		mailSender.send(mimeMessage);
	}
	
}

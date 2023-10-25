package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmailDetailes;
import com.example.demo.service.EmailService;
@Service
public class EmailServiceImppl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendEmail(EmailDetailes emailDetailes) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(sender);
		simpleMailMessage.setTo(emailDetailes.getRecipient());
		simpleMailMessage.setText(emailDetailes.getMsgBody());
		simpleMailMessage.setSubject(emailDetailes.getSubject());

		javaMailSender.send(simpleMailMessage);
		return "mail Sent success";
	}

}

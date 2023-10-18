package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmailDetailes;
import com.example.demo.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	@PostMapping("/sendMail")
	public String sendEmail(@RequestBody EmailDetailes emailDetailes) {
		String status = emailService.sendEmail(emailDetailes);
		return status;
	}

//	 @Scheduled(cron = "0 0 7 * * ?") // Trigger at 7 AM every day
	@Scheduled(cron = "0 * * * * ?")
	public void sendDailyEmail() {
		// Create an EmailDetails object with the necessary email content
		EmailDetailes emailDetails = new EmailDetailes();
		emailDetails.setRecipient("buddhishivaprasad7@gmail.com");
		emailDetails.setSubject("Daily Email");
		emailDetails.setMsgBody("This is your daily email sent at 7 AM.");
		String status = emailService.sendEmail(emailDetails);
		System.out.println("Scheduled email sent. Status: " + status);
	}
}

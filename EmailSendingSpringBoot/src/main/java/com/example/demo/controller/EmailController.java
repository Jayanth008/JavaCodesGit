package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmailDetailes;
import com.example.demo.repositry.GoldRepo;
import com.example.demo.repositry.PetrolRepo;
import com.example.demo.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	@Autowired
	private GoldRepo goldRepo;

	@Autowired
	private PetrolRepo petrolRepo;

	@PostMapping("/sendMail")
	public String sendEmail(@RequestBody EmailDetailes emailDetailes) {
		String status = emailService.sendEmail(emailDetailes);
		return status;
	}

//	 @Scheduled(cron = "0 0 7 * * ?") // Trigger at 7 AM every day
	@Scheduled(cron = "0 * * * * ?")
	public void sendDailyEmail() {
		// todays date
		LocalDate todayDate = LocalDate.now();

		String messageBody = "Good morning!\n\n" + "Here are the latest updates on today's gold and petrol rates:\n\n"
				+ "Gold Rate : " + goldRepo.findByDate(todayDate).getPrice() + "\n"
				+ "Petrol Price : " + petrolRepo.findByDate(todayDate).getPrice() + "\n\n"
				+ "Have a great day!";

		EmailDetailes emailDetails = new EmailDetailes();
		emailDetails.setRecipient("prudhvi.kalavakunta@capgemini.com");
		emailDetails.setSubject("JMS Test Email");
		emailDetails.setMsgBody(messageBody);
		String status = emailService.sendEmail(emailDetails);
		System.out.println("Scheduled email sent. Status: " + status);
	}
}

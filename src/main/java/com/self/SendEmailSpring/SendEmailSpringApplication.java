package com.self.SendEmailSpring;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


import com.self.SendEmailSpring.service.EmailSendService;

@SpringBootApplication
public class SendEmailSpringApplication {
	
	@Autowired
	private EmailSendService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SendEmailSpringApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendSimpleEmail("roshnikumari@gmail.com",
				"send Email by SpringBoot subject",
			  "Hi, \n Learning to send Email by SpringBoot body. \n\n Thanks & Regards \n Roshni Kumari");

	}

}

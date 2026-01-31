package com.hehe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hehe.demo.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class SendEmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping(value = "/sendmail")
	public ResponseEntity<Object> sendMail() throws MessagingException {
//		emailService.sendEmail("winterboy102@gmail.com", "Hello Hehe", "Welcome hehe!!!");
		emailService.sendHtmlEmail("winterboy102@gmail.com", "Hello Hehe", "<h1>Welcome hehe!!!</h1>");
		return new ResponseEntity<Object>("Email sent successfully!!!", HttpStatus.OK);
	}
}

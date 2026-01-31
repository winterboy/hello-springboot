package com.hehe.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	public AdminController() {
		logger.info("Admin Controller!!!");
	}
	
	@GetMapping(value = "")
	public ResponseEntity<Object> helloAdmin() {
		return new ResponseEntity<Object>("Welcome to Admin Resource!!!", HttpStatus.OK);
	}
}

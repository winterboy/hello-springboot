package com.hehe.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

	private static final Logger logger = LoggerFactory.getLogger(ThymeleafController.class);
	
	public ThymeleafController() {
		logger.info("Thymeleaf Controller Constructor!");
	}
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("message", "Hello Thymeleaf!!!");
		
		return "index";
	}
}

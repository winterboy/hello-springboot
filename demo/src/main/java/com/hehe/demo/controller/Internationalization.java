package com.hehe.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Internationalization {
	
	@GetMapping(value = "/international")
	public String internationalization() {
		return "international";
	}
}

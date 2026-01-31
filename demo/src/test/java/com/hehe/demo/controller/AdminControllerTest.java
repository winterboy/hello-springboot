package com.hehe.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@WebMvcTest(AdminController.class)
public class AdminControllerTest {

	private AdminController adminController = new AdminController();
	
//	@Autowired
//	private MockMvc mockMvc;
	
	@Test
	public void testHelloAdmin() {
		ResponseEntity<Object> result = adminController.helloAdmin();
		
		assertEquals("Welcome to Admin Resource!!!", result.getBody());
	}
	
//	@Test
//	public void testHelloAdmin2() throws Exception {
//		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/admin")).andReturn();
//		assertEquals("Welcome to Admin Resource!!!", mvcResult.getResponse().getContentAsString());
//	}
}

package com.hehe.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hehe.demo.service.ProductService;

@RestController
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {
		logger.info("Product Controller Constructor");
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts() {
		ResponseEntity<Object> responseEntity = 
				new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
		return responseEntity;
	}
}

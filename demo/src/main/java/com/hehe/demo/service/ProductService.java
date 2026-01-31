package com.hehe.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hehe.demo.model.Product;

@Service
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Value("${product.fruit.names}")
	private List<String> listFruits;
	
	private List<Product> listProducts;
	
	public ProductService() {
		logger.info("Product Service Constructor");
		
		listProducts = new ArrayList<>();
	}
	
	public List<Product> getProducts() {
		if(listProducts.size() == 0) {
			for(int i = 0; i < listFruits.size(); i++) {
				Product product = new Product(i, listFruits.get(i));
				listProducts.add(product);
			}
		}
		
		logger.info("Products:" + listProducts);
		return listProducts;
	}
}

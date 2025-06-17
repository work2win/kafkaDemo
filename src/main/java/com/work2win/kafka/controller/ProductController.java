package com.work2win.kafka.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work2win.kafka.model.Product;
import com.work2win.kafka.publish.KafkaPublishService;
import com.work2win.kafka.repo.ProductRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	KafkaPublishService service;
	
	@GetMapping("products")
	public List<Product> getProducts(){
		
		List<Product> products = productRepository.findAll();
		service.userInfo(products);
		return products;
	}

}
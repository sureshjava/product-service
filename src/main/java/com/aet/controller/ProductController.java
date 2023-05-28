package com.aet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aet.error.ProductNotFoundException;
import com.aet.model.ProductRequest;
import com.aet.model.ProductResponse;
import com.aet.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	Logger logger=LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest product){
	
		
		long id=productService.addProduct(product);
		logger.info("product added successfully");
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ProductResponse getProduct(@PathVariable long id) throws ProductNotFoundException, Exception {
		
		ProductResponse res=productService.getProduct(id);
		return res;
	}
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity) throws ProductNotFoundException{
		
		productService.reduceQuantity(productId,quantity);
		return null;
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") long productId, @RequestParam long quantity) throws Exception{
		
		productService.update(productId,quantity);
		return null;
		
	}
	@DeleteMapping("/{id}")
	public String  deleteProductId(@PathVariable("id") long productId) throws Exception {
	
		
		productService.deleteProductId(productId);
		return "product is deleted successfully";
	}
}

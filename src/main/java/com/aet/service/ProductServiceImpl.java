package com.aet.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
/*import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;*/
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aet.entity.Product;
import com.aet.error.ProductNotFoundException;
import com.aet.model.ProductRequest;
import com.aet.model.ProductResponse;
import com.aet.repository.ProductMongoRepository;
import com.aet.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;



@Service
public class ProductServiceImpl implements ProductService {
	
	//@Autowired
	//private ProductRepository prodRepository;
	
	Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	private ProductMongoRepository prodMongoRepository;
	
	
	/*
	 * @Autowired private KafkaTemplate<String, Product> kafkaTemplate;
	 */
	
	@Autowired
    ObjectMapper objectMapper;

	@Override
	public long addProduct(ProductRequest product) {
		// TODO Auto-generated method stub
	
		
		logger.info("addProduct method :"+product);
		Product productEntity=new Product();
		
		BeanUtils.copyProperties(product, productEntity);
		Product response=null;
		try {
			Random ran=new Random();
			int value=ran.nextInt(0, 1000);
			productEntity.setProductId(value);
		
			logger.info("successfully added id "+value);
		/*
		 * Message<User> message = MessageBuilder .withPayload(data)
		 * .setHeader(KafkaHeaders.TOPIC, AppConstants.TOPIC_NAME) .build();
		 * 
		 * 
		 */
			
			//Message<Product> message=MessageBuilder.withPayload(productEntity).setHeader(KafkaHeaders.TOPIC, "product-topic").build();
		response=prodMongoRepository.save(productEntity);
		logger.info("After saving  product : "+response);
		
		// kafkaTemplate.send(message);
		
		}catch(Exception exception) {
			exception.getStackTrace();
		}
		// response=prodRepository.save(productEntity);
		
		return response.getProductId();
	}

	@Override
	public ProductResponse getProduct(long id) throws ProductNotFoundException,Exception {
		// TODO Auto-generated method stub
		
		Product product=null;
		product=prodMongoRepository.findById(id).orElseThrow(()->new Exception("product id is not found"));
				//product=prodRepository.findById(id).orElseThrow(()->new Exception("product id is not found"));
		
		ProductResponse prodResponse=new ProductResponse();
		
		BeanUtils.copyProperties(product, prodResponse);
		return prodResponse;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		
		Product product=null;
		
		product=prodMongoRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("product with given id is not found"));
		// product=prodRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("product with given id is not found"));
		
		
		product.setQuantity(product.getQuantity()-quantity);
		
		prodMongoRepository.save(product);
		
		//prodRepository.save(product);
		
		System.out.println("product quantity updated successfully");
		
	}

	@Override
	public void deleteProductId(long productId) throws Exception {
		// TODO Auto-generated method stub
		
		
		prodMongoRepository.deleteById(productId);
	//	prodRepository.deleteById(productId);
		
	}

	@Override
	public void update(long productId, long quantity) throws ProductNotFoundException, Exception {
		// TODO Auto-generated method stub
		
		Product product=prodMongoRepository.findById(productId).orElseThrow(()->new Exception("product id is not found"));
		
		long quantity1=product.getQuantity();
		
		product.setQuantity(quantity1+quantity);
		
		prodMongoRepository.save(product);
		
	}
	


}

package com.aet;

//import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	/*
	 * @Bean public NewTopic javaguidesTopic(){ return
	 * TopicBuilder.name("product-topic") .build(); }
	 */
}

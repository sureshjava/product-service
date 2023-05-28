package com.aet.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document
public class Product {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long productId;
	
//	@Column(name="PRODUCT_NAME")
	private String productName;
	
	//@Column(name="PRICE")
	private long price;
	
	//@Column(name="QUANTITY")
	private long quantity;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
}

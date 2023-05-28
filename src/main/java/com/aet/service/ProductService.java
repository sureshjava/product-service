package com.aet.service;

import com.aet.error.ProductNotFoundException;
import com.aet.model.ProductRequest;
import com.aet.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest product);
	
	ProductResponse getProduct(long id) throws ProductNotFoundException, Exception;

	void reduceQuantity(long productId, long quantity) throws ProductNotFoundException;

	void  deleteProductId(long productId) throws Exception;

	void update(long productId, long quantity) throws ProductNotFoundException, Exception ;
}

package com.aet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aet.entity.Product;


@Repository
public interface ProductMongoRepository extends MongoRepository<Product, Long>{

}

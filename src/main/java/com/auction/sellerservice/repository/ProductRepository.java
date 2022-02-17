package com.auction.sellerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.sellerservice.model.ProductDetails;

public interface ProductRepository extends MongoRepository<ProductDetails, String> {

}

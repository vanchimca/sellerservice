package com.auction.sellerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auction.sellerservice.model.ProductDetails;
import com.auction.sellerservice.repository.ProductRepository;

@Service
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	private ProductRepository repository;
	
	public String saveProductDetails(ProductDetails productDetails) {
		
		productDetails = repository.save(productDetails);
		System.out.println("id -- "+productDetails.get_id());
		
		return "Saved Successfully";
	}
	
	public Optional<ProductDetails> retrieveProductDetails(String productId){
		
		Optional<ProductDetails> productDetails = repository.findById(productId);
		
		return productDetails;
	}
	public String deleteProduct(String productId) {
		
		repository.deleteById(productId);
		
		return "Deleted Successfully";
	}
	public List<ProductDetails> retrieveAllProducts(){
		
		List<ProductDetails> productDetails = repository.findAll();
		return productDetails;
	}

}

package com.auction.sellerservice.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.auction.sellerservice.model.ProductDetails;

public interface SellerService {

	public String saveProductDetails(ProductDetails productDetails);
	public Optional<ProductDetails> retrieveProductDetails(String productId);
	public String deleteProduct(String productId);
	public List<ProductDetails> retrieveAllProducts(); 
	public boolean isValidDate(Date bidEndDate) throws ParseException;
	
}

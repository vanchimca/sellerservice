package com.auction.sellerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auction.sellerservice.model.ProductDetails;
import com.auction.sellerservice.service.SellerService;


@RestController
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/e-auction/api/v1/seller/show-products")
	public ResponseEntity<List<ProductDetails>> retrieveAllProducts()  
	{  
		List<ProductDetails> prodouctDetails = sellerService.retrieveAllProducts();
		return  ResponseEntity.status(HttpStatus.OK).body(prodouctDetails);  
	}
	
	@PostMapping("/e-auction/api/v1/seller/add-product")
	public ResponseEntity<String> saveProductDetails(@RequestBody ProductDetails productDetails){
		
		sellerService.saveProductDetails(productDetails);
		System.out.println("id -- "+productDetails.get_id());
		return  ResponseEntity.status(HttpStatus.OK).body("Saved Successfully");
	}
	
	@GetMapping("/e-auction/api/v1/seller/product-details/{productId}")
	public ResponseEntity<Optional<ProductDetails>> retrieveProductDetails(@PathVariable("productId") String productId)  
	{  
		Optional<ProductDetails> prodouctDetails =sellerService.retrieveProductDetails(productId);
		return  ResponseEntity.status(HttpStatus.OK).body(prodouctDetails);  
	}
	
	@DeleteMapping("/e-auction/api/v1/seller/delete-product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") String productId)  
	{  
		sellerService.deleteProduct(productId);
		return  ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully.");  
	}
}

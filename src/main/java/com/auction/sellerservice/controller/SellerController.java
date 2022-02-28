package com.auction.sellerservice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.auction.sellerservice.model.ProductDetails;
import com.auction.sellerservice.service.SellerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	public ResponseEntity<String> saveProductDetails(@Valid @RequestBody ProductDetails productDetails) throws Exception{
		
		if(sellerService.isValidDate(productDetails.getBidEndDate())) {
			
			sellerService.saveProductDetails(productDetails);
			return  ResponseEntity.status(HttpStatus.OK).body("Saved Successfully");
		
		  }else { 
			  return  ResponseEntity.status(HttpStatus.OK).body("Bid End Date should be future date"); 
			  }
		 
	}
	
	@GetMapping("/e-auction/api/v1/seller/product-details/{productId}")
	public ResponseEntity<Optional<ProductDetails>> retrieveProductDetails(@PathVariable("productId") String productId)  
	{  
		Optional<ProductDetails> prodouctDetails =sellerService.retrieveProductDetails(productId);
		return  ResponseEntity.status(HttpStatus.OK).body(prodouctDetails);  
	}
	
	@DeleteMapping("/e-auction/api/v1/seller/delete-product/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") String productId)  throws Exception
	{  
		Optional<ProductDetails> productDetails = sellerService.retrieveProductDetails(productId);
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(new Date());
		productDetails.ifPresent(product -> {
			dateList.set(0, product.getBidEndDate());		    
		});
		if(!sellerService.isValidDate(dateList.get(0))) {
			return  ResponseEntity.status(HttpStatus.OK).body("Product can not be deleted after bid end date");
		}else {
			Map<String, String> uriVariables=new HashMap<>();
			uriVariables.put("productId", productId);
			//calling the currency exchange service
			ResponseEntity<Integer> responseEntity = new RestTemplate().getForEntity("http://localhost:8091/e-auction/api/v1/buyer/getCount/{productId}", Integer.class, uriVariables);
			Integer size =responseEntity.getBody();
			if(size > 0) {
			return  ResponseEntity.status(HttpStatus.OK).body("Product has bids, can not be deleted");
			}else {
			
		sellerService.deleteProduct(productId);
		return  ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully.");
		}  
		
		}
	}

}
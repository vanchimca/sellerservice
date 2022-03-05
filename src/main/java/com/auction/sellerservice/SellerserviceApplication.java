package com.auction.sellerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;*/

@SpringBootApplication
/*
 * @EnableFeignClients("com.auction.sellerservice")
 * 
 * @EnableEurekaClient
 */
public class SellerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerserviceApplication.class, args);
	}

}

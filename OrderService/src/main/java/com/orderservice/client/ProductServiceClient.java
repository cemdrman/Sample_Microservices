package com.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductServiceClient {

	@GetMapping(value = "/{productId}", produces = { "application/json" })
	ProductDTO readProduct(@PathVariable("productId") long productId) ;
}

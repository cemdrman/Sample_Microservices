package com.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("customer-service")
public interface CustomerServiceClient {

	@GetMapping("/{customerId}")
	CustomerDTO readCustomerById(@PathVariable("customerId") long customerId);

}

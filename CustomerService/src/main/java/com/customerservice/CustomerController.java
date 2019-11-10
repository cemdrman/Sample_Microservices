package com.customerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping("/{customerId}")
	public Customer readCustomer(@PathVariable("customerId") int customerId) {
		return new Customer(customerId, "Cem DIRMAN-" + customerId, "İTÜ ARI 6");
	}

}

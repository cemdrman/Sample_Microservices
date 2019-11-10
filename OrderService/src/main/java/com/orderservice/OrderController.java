package com.orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.client.CustomerDTO;
import com.orderservice.client.CustomerServiceClient;
import com.orderservice.client.ProductDTO;
import com.orderservice.client.ProductServiceClient;

@RestController
public class OrderController {

	private static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private CustomerServiceClient customerService;

	@Autowired
	private ProductServiceClient productService;

	@PostMapping
	public OrderResponceDTO createOrder(@RequestBody OrderRequestDTO requestDTO) {

		logger.info(requestDTO.toString());

		ProductDTO product = productService.readProduct(requestDTO.getProductId());

		CustomerDTO customer = customerService.readCustomerById(requestDTO.getCustomerId());

		OrderResponceDTO orderResponce = new OrderResponceDTO();
		orderResponce.setOrderId(requestDTO.getCustomerId() + "_" + requestDTO.getProductId());
		orderResponce.setTotalPrice(product.getPrice() * requestDTO.getCount());
		orderResponce.setMessage("Customere info" + customer.getName() + ",address " + customer.getAddress());

		return orderResponce;
	}

}

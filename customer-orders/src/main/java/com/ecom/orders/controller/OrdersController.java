package com.ecom.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.orders.request.OrdersRequest;
import com.ecom.orders.response.OrdersResponse;
import com.ecom.orders.service.OrdersService;

@RestController
@RequestMapping("orders")
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	
	//Creating a new Order 
	@PostMapping("/create")
	public ResponseEntity<OrdersResponse> createOrder(@RequestBody OrdersRequest ordersRequest){
		
		OrdersResponse response =ordersService.createOrder(ordersRequest);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		
	}

}

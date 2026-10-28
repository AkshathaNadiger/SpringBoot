package com.ecom.orders.service;

import java.util.Date;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecom.customer.entity.CustomerEntity;
import com.ecom.customer.repository.CustomerRepository;
import com.ecom.orders.entity.OrdersEntity;
import com.ecom.orders.repository.OrdersRepository;
import com.ecom.orders.request.OrdersRequest;
import com.ecom.orders.response.OrdersResponse;

@Service
public class OrdersService {
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	//Creating a new order 
	public OrdersResponse createOrder(@RequestBody OrdersRequest ordersRequest) {
		//getting customerId 
		String customerId = ordersRequest.getCustomerId();
		
		CustomerEntity customerEntity = customerRepository.findById(Long.valueOf(customerId)).get();
		
		OrdersEntity ordersEntity = new OrdersEntity();
		
		//Setting the orderRequests attribute
		ordersEntity.setCustomer(customerEntity);
		ordersEntity.setOrderNo(generateOrderNo());
		ordersEntity.setAmount(generateAmount());
		ordersEntity.setOrderDate(new Date());
		ordersEntity.setStatus("SUCCESS");
		
		OrdersEntity responseEntity = ordersRepository.save(ordersEntity);
		
		OrdersResponse ordersResponse = new OrdersResponse();
		
		//Setting the orderResponse attribute
		ordersResponse.setOrderNo(responseEntity.getOrderNo());
		ordersResponse.setAmount(responseEntity.getAmount());
		ordersResponse.setId(responseEntity.getId());
		ordersResponse.setStatus("PLACED");
		
		return ordersResponse;
		
		
			}
	
	
	
	//generating OrderNo Randomly
	private String generateOrderNo() {
		Random random = new Random();
		String OrNo = "OrNO" + 10000 + random.nextInt(90000);
		return OrNo;
	}
	
	//generating Amount Randomly
	private int generateAmount() {
		Random random = new Random();
		int amount = 1000 + random.nextInt(9000);
		return amount;
	}
	
	
	
}

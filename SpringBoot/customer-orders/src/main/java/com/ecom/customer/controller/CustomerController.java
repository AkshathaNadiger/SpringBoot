package com.ecom.customer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.customer.request.CustomerRequest;
import com.ecom.customer.response.CustomerResponse;
import com.ecom.customer.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	//Creating a new Customer
	@PostMapping("/create")
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
		CustomerResponse customerResponse = customerService.createCustomer(customerRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
		
	}
	
	
	
	//Getting all the customers
	@GetMapping("/customers")
	public List<CustomerResponse> getAllCustomers() {
	    return customerService.getAllCustomers();
	}
	
	
	
	
	//Getting particular customer by id
	@GetMapping("/customers/{id}")
    public CustomerResponse getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
	
	
	
	
	//Getting all the orders of a customer
	@GetMapping("showAllOrdersOfCustomers")
	public String getAllOrdersOfCustomer() {
		customerService.getAllOrdersOfCustomer();
		return "SUCCESS";
	}

}

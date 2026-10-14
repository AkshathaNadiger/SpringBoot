package com.ecom.customer.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.customer.entity.CustomerEntity;
import com.ecom.customer.exception.CustomerDoesNotExistsException;
import com.ecom.customer.repository.CustomerRepository;
import com.ecom.customer.request.CustomerRequest;
import com.ecom.customer.response.CustomerResponse;
import com.ecom.orders.entity.OrdersEntity;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public CustomerResponse createCustomer(CustomerRequest customerRequest) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		//Setting the request attributes
		customerEntity.setName(customerRequest.getName());
		customerEntity.setEmail(customerRequest.getEmail());
		customerEntity.setAddress(customerRequest.getAddress());
		customerEntity.setPhNo(customerRequest.getPhNo());
		customerEntity.setStatus("Active");
		
		//saving the request in DB using save method
	    CustomerEntity responseEntity = customerRepository.save(customerEntity);
	    
	    CustomerResponse customerResponse = new CustomerResponse();
	    
	    //Setting the response attributes
	    customerResponse.setId(responseEntity.getId());
		customerResponse.setName(responseEntity.getName());
		customerResponse.setStatus(responseEntity.getStatus());
		
		return customerResponse;
		
	}
	
	
	public List<CustomerResponse> getAllCustomers(){
		
		//findAll method retrives all the data 
		List<CustomerEntity> customerEntities = (List<CustomerEntity>) customerRepository.findAll();
		
		List<CustomerResponse> customerResponses = new ArrayList<CustomerResponse>();
		
		for(CustomerEntity customerEntity: customerEntities) {
			CustomerResponse customerResponse = new CustomerResponse();
			
			//Setting the response attributes
			customerResponse.setId(customerEntity.getId());
			customerResponse.setName(customerEntity.getName());
			customerResponse.setStatus(customerEntity.getStatus());

            customerResponses.add(customerResponse);
		}
		
		return customerResponses;
		
	}
	
	
	public CustomerResponse getCustomerById(Long id) {
		
		//CustomerEntity customerEntity = customerRepository.findById(id).get();
		//findById method retrives all the data of particular Id
		
		CustomerResponse customerResponse = new CustomerResponse();
		try {
			CustomerEntity customerEntity = customerRepository.findById(id).get();
		
			
		//Setting the response attributes
			

		customerResponse.setId(customerEntity.getId());
		customerResponse.setName(customerEntity.getName());
		customerResponse.setStatus(customerEntity.getStatus());
		}catch (Exception e) {
			//This exception handles when the customer is not found
			throw new CustomerDoesNotExistsException(" Customer id " + id + " does not exists");
		}
		return customerResponse;
		
	}
	
	public void getAllOrdersOfCustomer() {
		
		//List<CustomerEntity> customers = (List<CustomerEntity>) customerRepository.findAll();//This causes N+1 problem
		
		
		List<CustomerEntity> customers = customerRepository.getAllOrdersOfCustomer();//Using Left join fetch
		
		
		//List<CustomerEntity> customers = customerRepository.findAll();//using entity graph
		
		//Setting the response attributes
		
		for(CustomerEntity customerEntity: customers ) {
			System.out.println(customerEntity.getName());
			System.out.println(customerEntity.getId());
			
			//Getting the list of orders of a particular customer
			List<OrdersEntity> orders = customerEntity.getOrders();
			
			
			System.out.println("Total Orders are: " +orders.size());
		}
	}

}

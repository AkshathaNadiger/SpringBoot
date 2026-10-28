package com.ecom.customer.exception;

//Handling runtime exception
public class CustomerDoesNotExistsException extends RuntimeException {
	
	public CustomerDoesNotExistsException(String _message) {
		super(_message);
	}

}

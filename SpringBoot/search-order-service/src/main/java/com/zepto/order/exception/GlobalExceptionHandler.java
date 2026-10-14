package com.zepto.order.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.order.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(OrderDoesNotExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(OrderDoesNotExistsException e) {
		
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("ER-001");
		errorResponse.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		
	}

}
 
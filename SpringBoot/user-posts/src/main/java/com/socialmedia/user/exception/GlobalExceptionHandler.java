package com.socialmedia.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.socialmedia.user.response.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserDoesNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(UserDoesNotFoundException e) {
		
		//Printing error message 
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("ER-001");
		errorResponse.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		
	}

}

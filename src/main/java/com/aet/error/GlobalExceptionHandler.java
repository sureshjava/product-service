package com.aet.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> productNotFoundHandler(ProductNotFoundException exception) {
		System.out.println("test**");
		
		ErrorMessage error=new ErrorMessage(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ErrorMessage>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	
	public ResponseEntity<ErrorMessage> generalExcepion(Exception exception) {
		
System.out.println("test**");
		
		ErrorMessage error=new ErrorMessage(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ErrorMessage>(error,HttpStatus.INTERNAL_SERVER_ERROR);
}
}

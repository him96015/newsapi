package org.cis.cis.exception;

import java.util.Date;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //Applicable to all the Controllers
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//Take a look at ResponseEntityExceptionHandler and choose which method to override
	//We are taking Method Argument Not valid 
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),"Method not Valid",ex.getMessage());
		return new ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
	//We are taking HttpRequestMethodNotSupportedException and overriding it
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),"HttpRequestMethodNotSupported",ex.getMessage());
		return new ResponseEntity<Object>(customErrorDetails,HttpStatus.METHOD_NOT_ALLOWED);
		
	}
	
	
	// UserName not found Exception Handling
	@ExceptionHandler(UsernameNotFoundException.class) // because it is base method so we need to add this annotation
	public final ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException ex,WebRequest request){
	
		CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(customErrorDetails,HttpStatus.NOT_FOUND);
	}
	
	//When client tries  to enter any Empty String in request body
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),"HttpMessageNotReadable",ex.getMessage());
		return new ResponseEntity<Object>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
}

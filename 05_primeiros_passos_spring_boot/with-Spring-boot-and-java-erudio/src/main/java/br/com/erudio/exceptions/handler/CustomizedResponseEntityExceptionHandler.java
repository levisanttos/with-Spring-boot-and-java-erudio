package br.com.erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.erudio.exceptions.ExceptionResponse;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handlerExceptions(Exception ex, WebRequest webRequest) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handlerBadRequestExceptions(UnsupportedMathOperationException ex, WebRequest webRequest) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}

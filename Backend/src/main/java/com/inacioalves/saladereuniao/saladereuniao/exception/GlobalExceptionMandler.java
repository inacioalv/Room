package com.inacioalves.saladereuniao.saladereuniao.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionMandler {

	@ExceptionHandler(ResourceMotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException (ResourceMotFoundException ex, WebRequest request){
		ErrorDatails errorDatails = new ErrorDatails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDatails,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> globalExceptionMandler(ResourceMotFoundException ex, WebRequest request){
		ErrorDatails errorDatails = new ErrorDatails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDatails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

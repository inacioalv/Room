package com.inacioalves.saladereuniao.saladereuniao.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceMotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ResourceMotFoundException(String msg) {
		super(msg);
	}

}

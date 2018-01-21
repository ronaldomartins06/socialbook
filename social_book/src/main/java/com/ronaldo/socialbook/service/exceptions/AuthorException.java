package com.ronaldo.socialbook.service.exceptions;

public class AuthorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AuthorException(String message){
		super(message);
	}
	
	public AuthorException(String message, Throwable cause){
		super(message, cause);
	}

	
}

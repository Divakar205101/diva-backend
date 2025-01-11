package com.diva.exception;

public class InvalidJwtTokenException extends RuntimeException{

	public InvalidJwtTokenException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidJwtTokenException(String message) {
		super(message);
	}
	
	

}

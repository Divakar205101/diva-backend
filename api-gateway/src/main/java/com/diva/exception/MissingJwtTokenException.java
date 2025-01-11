package com.diva.exception;

public class MissingJwtTokenException extends RuntimeException {

	public MissingJwtTokenException(String message) {
		super(message);
	}

	public MissingJwtTokenException(String message, Throwable cause) {
		super(message, cause);
	}
}

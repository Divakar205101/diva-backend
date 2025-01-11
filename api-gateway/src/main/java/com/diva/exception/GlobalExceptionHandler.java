package com.diva.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MissingJwtTokenException.class)
	 public ResponseEntity<Map<String, Object>> handleMissingTokenException(MissingJwtTokenException ex){
		 Map<String, Object> response = new HashMap<>();
	        response.put("timestamp", LocalDateTime.now());
	        response.put("status", HttpStatus.UNAUTHORIZED.value());
	        response.put("error", HttpStatus.UNAUTHORIZED.getReasonPhrase());
	        response.put("message", ex.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	 }
	 
	   @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("timestamp", LocalDateTime.now());
	        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        response.put("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
	        response.put("message", ex.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	   
	   @ExceptionHandler(InvalidJwtTokenException.class)
	   public ResponseEntity<?> jwtTokenInvaid(Exception ex) { 
		   return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
	   }

}

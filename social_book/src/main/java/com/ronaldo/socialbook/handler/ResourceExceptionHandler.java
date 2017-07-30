package com.ronaldo.socialbook.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ronaldo.socialbook.domain.ErrorDetail;
import com.ronaldo.socialbook.service.exceptions.BookNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDetail> handleBookNotFound(BookNotFoundException ex, HttpServletRequest request ){
		
		ErrorDetail error = new ErrorDetail();
		error.setStatus(404L);
		error.setTitle("The Book required could not be found.");
		error.setMessage("http://errors.socialbook.com/404");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}

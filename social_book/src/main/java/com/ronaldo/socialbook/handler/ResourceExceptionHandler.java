package com.ronaldo.socialbook.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ronaldo.socialbook.domain.ErrorDetail;
import com.ronaldo.socialbook.service.exceptions.AuthorException;
import com.ronaldo.socialbook.service.exceptions.AuthorNotFoundException;
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
	
	@ExceptionHandler(AuthorException.class)
	public ResponseEntity<ErrorDetail> handleExistsAuthor(AuthorException ex, HttpServletRequest request ){
		
		ErrorDetail error = new ErrorDetail();
		error.setStatus(409L);
		error.setTitle("Author already exists.");
		error.setMessage("http://errors.socialbook.com/409");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<ErrorDetail> handleAuthorNotFoundException(AuthorNotFoundException ex, HttpServletRequest request ){
		
		ErrorDetail error = new ErrorDetail();
		error.setStatus(404L);
		error.setTitle("Author could not be found.");
		error.setMessage("http://errors.socialbook.com/404");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetail> handleDataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request ){
		
		ErrorDetail error = new ErrorDetail();
		error.setStatus(400L);
		error.setTitle("Invalid Request!");
		error.setMessage("http://errors.socialbook.com/400");
		error.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}

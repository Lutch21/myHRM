package com.jakolo.hrm.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	// @ExceptionHandler(HttpMessageNotReadableException.class)

	
	  public final ResponseEntity<Object>
	  handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders
	  headers, HttpStatusCode status, WebRequest request) {
	  
	  ProblemDetail body = ProblemDetail.forStatusAndDetail(status,
	  "Failed to read request body"); ErrorDetails errorDetails = new
	  ErrorDetails(LocalDateTime.now(), ex.getMessage(),
	  request.getDescription(false));
	  
	  
	  return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST); 
	  // return	  handleExceptionInternal(ex, body, headers, status, request);
	  
	  }
	 

	/*
	 * @ExceptionHandler(SystemException.class) public final
	 * ResponseEntity<ErrorDetails> handleNoSuchElementExceptions(Exception ex,
	 * WebRequest request) { ErrorDetails errorDetails = new
	 * ErrorDetails(LocalDateTime.now(), ex.getMessage(),
	 * request.getDescription(false)); return new ResponseEntity(errorDetails,
	 * HttpStatus.BAD_REQUEST); }
	 */

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		log.info("Error count " + ex.getErrorCount() + " :"+request.toString());

		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);

	}

}

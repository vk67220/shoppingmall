package com.shoppingmall.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author muralinutalapati
 */
@ControllerAdvice
@Order(2)
public class ResponseEntityExceptions extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponseBean errorResponseBean = new ErrorResponseBean(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(), request.getDescription(false);
		return new ResponseEntity<>(errorResponseBean, HttpStatus.BAD_REQUEST);
	}
}

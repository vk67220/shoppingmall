package com.shoppingmall.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author muralinutalapati
 */
@ControllerAdvice
@Order(1)
public class GlobalException {

  @ExceptionHandler
  public ResponseEntity<ErrorResponseBean> handleException(CustomerNotFoundException cnfe, WebRequest wr) {
    ErrorResponseBean errorResponseBean =
          new ErrorResponseBean(HttpStatus.NOT_FOUND.value(), new Date(), cnfe.getMessage(), wr.getDescription(false));
    return new ResponseEntity<>(errorResponseBean, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<ErrorResponseBean> handleException(Exception cnfe, WebRequest wr) {
    ErrorResponseBean errorResponseBean =
          new ErrorResponseBean(HttpStatus.BAD_REQUEST.value(), new Date(), cnfe.getMessage(), wr.getDescription(false));
    return new ResponseEntity<>(errorResponseBean, HttpStatus.BAD_REQUEST);
  }
}

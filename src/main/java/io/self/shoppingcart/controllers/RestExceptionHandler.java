package io.self.shoppingcart.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler({ConstraintViolationException.class})
  protected ResponseEntity<Object> handleConstraintViolationException(
      ConstraintViolationException e) {
    String message = e.getMessage().split(".")[1];
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
  }
}

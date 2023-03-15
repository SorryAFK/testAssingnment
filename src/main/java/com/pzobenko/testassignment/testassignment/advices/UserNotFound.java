package com.pzobenko.testassignment.testassignment.advices;

import com.pzobenko.testassignment.testassignment.exceptions.TheUserNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class UserNotFound {

  private static final String NOT_FOUND = "NOT_FOUND";
  @ExceptionHandler(TheUserNotFoundException.class)
  public final ResponseEntity<ErrorResponse> handleInvalidTraceIdException
      (TheUserNotFoundException ex) {
    List<String> details = new ArrayList<>();
    details.add(ex.getMessage());
    ErrorResponse error = new ErrorResponse(NOT_FOUND, details);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
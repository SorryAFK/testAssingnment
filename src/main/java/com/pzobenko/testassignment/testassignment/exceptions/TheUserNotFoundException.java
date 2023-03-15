package com.pzobenko.testassignment.testassignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TheUserNotFoundException extends RuntimeException {

  public TheUserNotFoundException(Long id) {
    super("User with id " + id + " not found!");
  }

}

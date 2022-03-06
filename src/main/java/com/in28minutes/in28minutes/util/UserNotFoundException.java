package com.in28minutes.in28minutes.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(long userId) {
    super(String.format("User with id %s can't be found.", userId));
  }
}

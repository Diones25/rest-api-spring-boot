package br.com.diones.rest_api_spring_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationExcetion extends RuntimeException {

  public UnsupportedMathOperationExcetion(String message) {
    super(message);
  }
}

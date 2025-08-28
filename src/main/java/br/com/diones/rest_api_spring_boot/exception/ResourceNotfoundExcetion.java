package br.com.diones.rest_api_spring_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotfoundExcetion extends RuntimeException {

  public ResourceNotfoundExcetion(String message) {
    super(message);
  }
}

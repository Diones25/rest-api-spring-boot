package br.com.diones.rest_api_spring_boot.exception.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.diones.rest_api_spring_boot.exception.ExceptionResponse;
import br.com.diones.rest_api_spring_boot.exception.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {
    ExceptionResponse response = new ExceptionResponse(
      new Date(),
      ex.getMessage(),
      request.getDescription(false)
    );

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
    ExceptionResponse response = new ExceptionResponse(
      new Date(),
      ex.getMessage(),
      request.getDescription(false)
    );

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
  
  // Sobrescrevendo o tratamento de validação
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    Map<String, String> errors = new HashMap<>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.put(error.getField(), error.getDefaultMessage());
    }
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}

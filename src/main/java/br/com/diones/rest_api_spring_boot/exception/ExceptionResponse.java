package br.com.diones.rest_api_spring_boot.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}

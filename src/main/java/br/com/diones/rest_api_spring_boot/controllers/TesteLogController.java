package br.com.diones.rest_api_spring_boot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteLogController {
  
  private Logger logger = LoggerFactory.getLogger(TesteLogController.class);

  @GetMapping("/teste")
  public String testeLog() {
    logger.debug("DEBUG log");
    logger.info("INFO log");
    logger.warn("WARNING log");
    logger.error("ERROR log");
    return "Logs genereted successfully";
  }
}

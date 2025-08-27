package br.com.diones.rest_api_spring_boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diones.rest_api_spring_boot.models.Person;
import br.com.diones.rest_api_spring_boot.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonService service;

  @GetMapping()
  public List<Person> findAll() {
    return service.findAll();
  }

  @GetMapping("{id}")
  public Person findById(@PathVariable("id") String id) {
    return service.findById(id);
  }
}

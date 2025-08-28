package br.com.diones.rest_api_spring_boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

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

  @PostMapping()
  public Person create(@RequestBody Person person) {
    return service.create(person);
  }

  @PutMapping()
  public Person update(@RequestBody Person person) {
    return service.update(person);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") String id) {
    service.delete(id);
  }
}

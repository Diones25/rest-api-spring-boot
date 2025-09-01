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

import br.com.diones.rest_api_spring_boot.dto.PersonDTO;
import br.com.diones.rest_api_spring_boot.mapper.PersonMapper;
import br.com.diones.rest_api_spring_boot.models.Person;
import br.com.diones.rest_api_spring_boot.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonService service;
  private PersonMapper personMapper;

  @GetMapping()
public List<Person> findAll() {
  List<PersonDTO> dtos = service.findAll();
  return personMapper.toEntityList(dtos);
}

  @GetMapping("{id}")
  public Person findById(@PathVariable("id") Long id) {
    return personMapper.toEntity(service.findById(id));
  }

  @PostMapping()
  public Person create(@RequestBody Person person) {
    PersonDTO personDTO = personMapper.toDTO(person);
    return personMapper.toEntity(service.create(personDTO));
  }

  @PutMapping()
  public Person update(@RequestBody Person person) {
    PersonDTO personDTO = personMapper.toDTO(person);
    return personMapper.toEntity(service.update(personDTO));
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") Long id) {
    service.delete(id);
  }
}

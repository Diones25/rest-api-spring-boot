package br.com.diones.rest_api_spring_boot.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.http.ResponseEntity;

import br.com.diones.rest_api_spring_boot.dtos.PersonRequestDTO;
import br.com.diones.rest_api_spring_boot.dtos.PersonResponseDTO;
import br.com.diones.rest_api_spring_boot.mapper.PersonMapper;
import br.com.diones.rest_api_spring_boot.models.Person;
import br.com.diones.rest_api_spring_boot.services.PersonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonService personService;

  @Autowired
  private PersonMapper personMapper;

  @GetMapping
  public ResponseEntity<List<PersonResponseDTO>> findAll() {
    List<PersonResponseDTO> persons = personService.findAll()
        .stream()
        .map(personMapper::toResponseDTO)
        .collect(Collectors.toList());
    return ResponseEntity.ok(persons);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PersonResponseDTO> buscarPorId(@PathVariable Long id) {
    Person person = personService.findById(id);
    return ResponseEntity.ok(personMapper.toResponseDTO(person));
  }

  @PostMapping
  public ResponseEntity<PersonResponseDTO> criar(@Valid @RequestBody PersonRequestDTO dto) {
    Person person = personMapper.toEntity(dto);
    Person personSave = personService.create(person);
    return ResponseEntity.ok(personMapper.toResponseDTO(personSave));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PersonResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PersonRequestDTO dto) {
    Person person = personMapper.toEntity(dto);
    person.setId(id);
    Person personUpdated = personService.update(person);
    return ResponseEntity.ok(personMapper.toResponseDTO(personUpdated));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    personService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

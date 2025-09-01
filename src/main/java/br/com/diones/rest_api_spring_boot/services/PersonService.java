package br.com.diones.rest_api_spring_boot.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diones.rest_api_spring_boot.dto.PersonDTO;
import br.com.diones.rest_api_spring_boot.exception.ResourceNotfoundExcetion;
import br.com.diones.rest_api_spring_boot.mapper.PersonMapper;
import br.com.diones.rest_api_spring_boot.models.Person;
import br.com.diones.rest_api_spring_boot.repository.PersonRepository;

@Service
public class PersonService {

  private final Logger logger = LoggerFactory.getLogger(PersonService.class);

  private final PersonRepository repository;
  private final PersonMapper mapper;

  @Autowired
  public PersonService(PersonRepository repository, PersonMapper mapper) {
      this.repository = repository;
      this.mapper = mapper;
  }

  public List<PersonDTO> findAll() {
    logger.info("Buscando uma lista de pessoas!");
    List<Person> persons = repository.findAll();
    return mapper.toDTOList(persons);
  }

  public PersonDTO findById(Long id) {
    logger.info("Buscando pessoa com ID: {}", id);
    Person entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotfoundExcetion("Pessoa com o id: " + id + " não encontrada!"));
    return mapper.toDTO(entity);
  }

  public PersonDTO create(PersonDTO dto) {
    logger.info("Criando uma pessoa!");
    Person entity = mapper.toEntity(dto);
    Person savedEntity = repository.save(entity);
    return mapper.toDTO(savedEntity);
  }

  public PersonDTO update(PersonDTO dto) {
    logger.info("Atualizando uma pessoa!");

    Person entity = repository.findById(dto.getId())
        .orElseThrow(() -> new ResourceNotfoundExcetion("Pessoa com o id: " + dto.getId() + " não encontrada!"));

    // Atualiza apenas os campos que podem ser alterados
    entity.setFirstName(dto.getFirstName());
    entity.setLastName(dto.getLastName());
    entity.setAddress(dto.getAddress());
    entity.setGender(dto.getGender());

    Person updated = repository.save(entity);
    return mapper.toDTO(updated);
  }

  public void delete(Long id) {
    logger.info("Deletando uma pessoa!");
    Person entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotfoundExcetion("Pessoa com o id: " + id + " não encontrada!"));

    repository.delete(entity);
  }
}

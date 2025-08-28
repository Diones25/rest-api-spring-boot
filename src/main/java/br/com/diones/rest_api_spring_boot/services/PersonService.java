package br.com.diones.rest_api_spring_boot.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.diones.rest_api_spring_boot.exception.ResourceNotfoundExcetion;
import br.com.diones.rest_api_spring_boot.models.Person;
import br.com.diones.rest_api_spring_boot.repository.PersonRepository;

@Service
public class PersonService {

  private Logger logger = Logger.getLogger(PersonService.class.getName());

  @Autowired
  private PersonRepository repository;

  public List<Person> findAll() {
    logger.info("Buscando uma lista de pessoas!");
    return repository.findAll();
  }

  public Person findById(Long id) {
    logger.info("Buscando uma pessoa!");
    return repository.findById(id)
      .orElseThrow(() -> new ResourceNotfoundExcetion("Pessoa com o id: "+id+" não encontrada!"));
  }

  public Person create(Person person) {
    logger.info("Criando uma pessoa!");
    return repository.save(person);
  }

  public Person update(Person person) {
    logger.info("Atualizando uma pessoa!");

    Person entity = repository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotfoundExcetion("Pessoa com o id: " + person.getId() + " não encontrada!"));

    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());
        
    return repository.save(person);
  }

  public void delete(Long id) {
    logger.info("Deletando uma pessoa!");
    Person entity =repository.findById(id)
        .orElseThrow(() -> new ResourceNotfoundExcetion("Pessoa com o id: " + id + " não encontrada!"));

    repository.delete(entity);
  }
}

package br.com.diones.rest_api_spring_boot.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diones.rest_api_spring_boot.controllers.TesteLogController;
import br.com.diones.rest_api_spring_boot.models.Person;
import br.com.diones.rest_api_spring_boot.exception.ResourceNotfoundExcetion;
import br.com.diones.rest_api_spring_boot.repository.PersonRepository;

@Service
public class PersonService {

  private Logger logger = LoggerFactory.getLogger(TesteLogController.class);

  @Autowired
  private PersonRepository personRepository;

  public List<Person> findAll() {
    logger.info("Buscando uma lista de pessoas!");
    return personRepository.findAll();
  }

  public Person findById(Long id) {
    logger.info("Buscando uma pessoa!");
    return personRepository.findById(id)
      .orElseThrow(() -> new ResourceNotfoundExcetion("Pessoa com o id: "+id+" não encontrada!"));
  }

  public Person create(Person person) {
    logger.info("Criando uma pessoa!");
    return personRepository.save(person);
  }

  public Person update(Person person) {
    logger.info("Atualizando uma pessoa!");

    if(!personRepository.existsById(person.getId())) {
      throw new ResourceNotfoundExcetion("Pessoa com o id: "+person.getId()+" não encontrada!");
    }
    return personRepository.save(person);
  }

  public void delete(Long id) {
    logger.info("Deletando uma pessoa!");
    if (!personRepository.existsById(id)) {
      throw new ResourceNotfoundExcetion("Pessoa com o id: " + id + " não encontrada!");
    }

    personRepository.deleteById(id);
  }
}

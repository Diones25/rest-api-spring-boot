package br.com.diones.rest_api_spring_boot.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.diones.rest_api_spring_boot.models.Person;

@Service
public class PersonService {
  
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonService.class.getName());


  public Person findById(String id) {
    logger.info("Finding one Person!");

    Person person = new Person();    
    person.setId(counter.incrementAndGet());
    person.setFirstName("Diones");
    person.setLastName("Santos");
    person.setAddress("Fortaleza - CE - Brasil");
    person.setGender("Male");
    return person;
  }
}

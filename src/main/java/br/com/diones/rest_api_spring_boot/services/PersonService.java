package br.com.diones.rest_api_spring_boot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import br.com.diones.rest_api_spring_boot.models.Person;

@Service
public class PersonService {
  
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonService.class.getName());

  public List<Person> findAll() {
    logger.info("Buscando uma lista de pessoas!");

    List<Person> persons = new ArrayList<Person>();

    for (int i = 0; i < 8; i++) {
      Person person = mockPerson(i);
      persons.add(person);
    }

    return persons;
  }

  public Person findById(String id) {
    logger.info("Buscando uma pessoa!");

    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Diones");
    person.setLastName("Santos");
    person.setAddress("Fortaleza - CE - Brasil");
    person.setGender("Male");
    return person;
  }
  
  public Person mockPerson(int i) {
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Person Name " + i);
    person.setLastName("Last Name " + i);
    person.setAddress("Some Address in Brasil " + i);
    person.setGender("Male");
    return person;
  }
}

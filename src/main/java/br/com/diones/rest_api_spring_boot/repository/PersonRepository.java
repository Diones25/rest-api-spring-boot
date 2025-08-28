package br.com.diones.rest_api_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.diones.rest_api_spring_boot.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

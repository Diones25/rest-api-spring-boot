package br.com.diones.rest_api_spring_boot.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

/*
 * A anotação @Data do Lombok gera automaticamente os métodos getters, setters,
 * toString, equals e hashCode para a classe PersonDTO. Isso reduz a quantidade
 * de código boilerplate que você precisa escrever, tornando o código mais limpo
 * e fácil de manter.
*/
@Data
public class PersonDTO {

  @NotBlank
  private String firstName;
  private String lastName;
  private String address;
  private String gender;
}

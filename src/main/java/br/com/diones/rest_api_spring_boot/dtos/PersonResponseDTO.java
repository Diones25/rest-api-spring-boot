package br.com.diones.rest_api_spring_boot.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class PersonResponseDTO {
  
  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String gender;

  public PersonResponseDTO() {
  }
}

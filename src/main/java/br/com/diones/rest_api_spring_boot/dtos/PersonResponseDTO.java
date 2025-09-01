package br.com.diones.rest_api_spring_boot.dtos;

import lombok.Data;

@Data
public class PersonResponseDTO {
  
  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String gender;

  public PersonResponseDTO() {
  }
}

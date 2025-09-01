package br.com.diones.rest_api_spring_boot.dtos;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonRequestDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;

  @NotBlank(message = "O primeiro nome é obrigatório")
  @Size(max = 80, message = "O primeiro nome deve ter no máximo 80 caracteres")
  private String firstName;

  @NotBlank(message = "O sobrenome é obrigatório")
  @Size(max = 80, message = "O sobrenome deve ter no máximo 80 caracteres")
  private String lastName;

  @NotBlank(message = "O endereço é obrigatório")
  @Size(max = 100, message = "O endereço deve ter no máximo 100 caracteres")
  private String address;

  @NotBlank(message = "O gênero é obrigatório")
  @Size(max = 6, message = "O gênero deve ter no máximo 6 caracteres")
  private String gender;

  public PersonRequestDTO() {
  }
}

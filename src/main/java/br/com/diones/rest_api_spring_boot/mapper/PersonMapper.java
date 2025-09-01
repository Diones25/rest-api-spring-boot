package br.com.diones.rest_api_spring_boot.mapper;

import br.com.diones.rest_api_spring_boot.dtos.PersonRequestDTO;
import br.com.diones.rest_api_spring_boot.dtos.PersonResponseDTO;
import br.com.diones.rest_api_spring_boot.models.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
  Person toEntity(PersonRequestDTO dto);

  PersonResponseDTO toResponseDTO(Person produto);
}

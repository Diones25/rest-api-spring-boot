package br.com.diones.rest_api_spring_boot.mapper;

import br.com.diones.rest_api_spring_boot.dto.PersonDTO;
import br.com.diones.rest_api_spring_boot.models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring") // ou "default" se não quiser Spring Bean
public interface PersonMapper {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  // DTO -> Entity
  Person toEntity(PersonDTO dto);

  // Entity -> DTO
  PersonDTO toDTO(Person entity);

  // List<Entity> -> List<DTO>
  List<PersonDTO> toDTOList(List<Person> entities);

  // List<DTO> -> List<Entity>
  List<Person> toEntityList(List<PersonDTO> dtos);
}

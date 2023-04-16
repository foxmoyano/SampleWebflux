package cl.foxcorp.woff.samplewebflux.mapper;

import cl.foxcorp.woff.samplewebflux.dto.PersonDTO;
import cl.foxcorp.woff.samplewebflux.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO personToPersonDto(Person entity);
    Person personDtoToPerson(PersonDTO dto);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreation", ignore = true)
    Person updatePersonFromPersonDto(PersonDTO dto, @MappingTarget Person entity);
}
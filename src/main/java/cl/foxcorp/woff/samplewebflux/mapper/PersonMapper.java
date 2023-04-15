package cl.foxcorp.woff.samplewebflux.mapper;

import cl.foxcorp.woff.samplewebflux.dto.PersonDTO;
import cl.foxcorp.woff.samplewebflux.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO personToPersonDto(Person person);
    Person personDtoToPerson(PersonDTO personDTO);
}


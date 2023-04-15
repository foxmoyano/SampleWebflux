package cl.foxcorp.woff.samplewebflux.service;

import cl.foxcorp.woff.samplewebflux.dto.PersonDTO;
import cl.foxcorp.woff.samplewebflux.entity.Person;
import cl.foxcorp.woff.samplewebflux.mapper.PersonMapper;
import cl.foxcorp.woff.samplewebflux.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public Flux<PersonDTO> findAll() {
        return personRepository.findAll()
                .map(personMapper::personToPersonDto);
    }

    public Mono<PersonDTO> findById(String id) {
        return personRepository.findById(id)
                .map(personMapper::personToPersonDto);
    }

    public Mono<PersonDTO> save(PersonDTO personDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        personDto.setDateCreation(localDateTime.toLocalDate());
        Person person = personMapper.personDtoToPerson(personDto);
        return personRepository.save(person)
                .map(personMapper::personToPersonDto);
    }

    public Mono<Void> deleteById(String id) {
        return personRepository.deleteById(id);
    }
}

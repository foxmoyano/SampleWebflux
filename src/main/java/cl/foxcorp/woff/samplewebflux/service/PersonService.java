package cl.foxcorp.woff.samplewebflux.service;

import cl.foxcorp.woff.samplewebflux.dto.PersonDTO;
import cl.foxcorp.woff.samplewebflux.entity.Person;
import cl.foxcorp.woff.samplewebflux.helper.CommonHelper;
import cl.foxcorp.woff.samplewebflux.mapper.PersonMapper;
import cl.foxcorp.woff.samplewebflux.repository.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    private final CommonHelper commonHelper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper, CommonHelper commonHelper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.commonHelper = commonHelper;
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
        LocalDateTime dateCurrent = this.commonHelper.getCurrentDate();
        Person person = personMapper.personDtoToPerson(personDto);
        person.setDateCreation(dateCurrent);
        return personRepository.save(person)
                .map(personMapper::personToPersonDto);
    }

    public Mono<PersonDTO> update(String id, PersonDTO personDto) {
        return personRepository.findById(id)
                .flatMap(person -> {
                    personMapper.updatePersonFromPersonDto(personDto, person);
                    return personRepository.save(person)
                            .map(personMapper::personToPersonDto);
                });
    }

    public Mono<Void> deleteById(String id) {
        return personRepository.deleteById(id);
    }
}
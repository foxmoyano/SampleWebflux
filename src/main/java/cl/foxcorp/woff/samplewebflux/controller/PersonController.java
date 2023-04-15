package cl.foxcorp.woff.samplewebflux.controller;

import cl.foxcorp.woff.samplewebflux.dto.PersonDTO;
import cl.foxcorp.woff.samplewebflux.entity.Person;
import cl.foxcorp.woff.samplewebflux.service.PersonService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Flux<PersonDTO> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PersonDTO> findById(@PathVariable String id) {
        return personService.findById(id);
    }

    @PostMapping
    public Mono<PersonDTO> save(@RequestBody PersonDTO personDto) {
        return personService.save(personDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return personService.deleteById(id);
    }
}
package cl.foxcorp.woff.samplewebflux.controller;

import cl.foxcorp.woff.samplewebflux.dto.PersonDTO;
import cl.foxcorp.woff.samplewebflux.service.PersonService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

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
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID no v\u00e1lido");
        }

        return personService.findById(id);
    }

    @PostMapping
    public Mono<PersonDTO> save(@RequestBody PersonDTO personDto) {
        return personService.save(personDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PersonDTO> update(@PathVariable String id, @RequestBody @Valid PersonDTO personDto) {
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID no v\u00e1lido");
        }

        return personService.update(id, personDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID no v\u00e1lido");
        }

        return personService.deleteById(id);
    }

}
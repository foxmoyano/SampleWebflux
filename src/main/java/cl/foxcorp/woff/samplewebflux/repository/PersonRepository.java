package cl.foxcorp.woff.samplewebflux.repository;

import cl.foxcorp.woff.samplewebflux.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
}

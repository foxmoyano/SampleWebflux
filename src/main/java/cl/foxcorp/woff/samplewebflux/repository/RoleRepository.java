package cl.foxcorp.woff.samplewebflux.repository;

import cl.foxcorp.woff.samplewebflux.entity.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoleRepository extends ReactiveMongoRepository<Role, String> {
}

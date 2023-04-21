package cl.foxcorp.woff.samplewebflux.repository;

import cl.foxcorp.woff.samplewebflux.entity.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
}

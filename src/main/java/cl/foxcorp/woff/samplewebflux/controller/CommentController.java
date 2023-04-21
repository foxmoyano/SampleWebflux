package cl.foxcorp.woff.samplewebflux.controller;

import cl.foxcorp.woff.samplewebflux.dto.CommentDTO;
import cl.foxcorp.woff.samplewebflux.service.CommentService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public Flux<CommentDTO> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<CommentDTO> findIdBy(@PathVariable String id) {
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch(IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID no v\u00e1lido");
        }

        return commentService.findById(id);
    }

    @PostMapping
    public Mono<CommentDTO> save(@RequestBody CommentDTO commentDTO) {
        return commentService.save(commentDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CommentDTO> update(@PathVariable String id, @RequestBody @Valid CommentDTO commentDTO) {
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch(IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID no v\u00e1lido");
        }

        return commentService.update(id, commentDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch(IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID no v\u00e1lido");
        }

        return commentService.deleteById(id);
    }
}
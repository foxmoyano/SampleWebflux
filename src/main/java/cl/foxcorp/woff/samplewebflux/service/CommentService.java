package cl.foxcorp.woff.samplewebflux.service;

import cl.foxcorp.woff.samplewebflux.dto.CommentDTO;
import cl.foxcorp.woff.samplewebflux.entity.Comment;
import cl.foxcorp.woff.samplewebflux.helper.CommonHelper;
import cl.foxcorp.woff.samplewebflux.mapper.CommentMapper;
import cl.foxcorp.woff.samplewebflux.repository.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final CommonHelper commonHelper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, CommonHelper commonHelper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.commonHelper = commonHelper;
    }

    public Flux<CommentDTO> findAll() {
        return commentRepository.findAll()
                .map(commentMapper::commentToCommentDto);
    }

    public Mono<CommentDTO> findById(String id) {
        return commentRepository.findById(id)
                .map(commentMapper::commentToCommentDto);
    }

    public Mono<CommentDTO> save(CommentDTO commentDTO) {
        LocalDateTime dateCurrent = this.commonHelper.getCurrentDate();
        Comment comment = commentMapper.commentDtoToComment(commentDTO);
        comment.setDateCreation(dateCurrent);
        return commentRepository.save(comment)
                .map(commentMapper::commentToCommentDto);
    }

    public Mono<CommentDTO> update(String id, CommentDTO commentDto) {
        return commentRepository.findById(id)
                .flatMap(comment -> {
                    commentMapper.updateCommentFromCommentDto(commentDto, comment);
                    return commentRepository.save(comment)
                            .map(commentMapper::commentToCommentDto);
                });
    }

    public Mono<Void> deleteById(String id) {
        return commentRepository.deleteById(id);
    }
}
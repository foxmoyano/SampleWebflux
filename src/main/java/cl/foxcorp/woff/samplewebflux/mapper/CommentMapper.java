package cl.foxcorp.woff.samplewebflux.mapper;

import cl.foxcorp.woff.samplewebflux.dto.CommentDTO;
import cl.foxcorp.woff.samplewebflux.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface CommentMapper {
    CommentDTO commentToCommentDto(Comment entity);
    Comment commentDtoToComment(CommentDTO dto);
    @Mapping(target = "id", ignore = true)
    Comment updateCommentFromCommentDto(CommentDTO dto, @MappingTarget Comment entity);
}

package banatech.gn.preguie_blogservice.service.comment;

import banatech.gn.preguie_blogservice.dto.PostCommentDTO;
import banatech.gn.preguie_blogservice.model.PostComment;
import banatech.gn.preguie_blogservice.service.EntityMapper;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PostCommentMapper extends EntityMapper {

    public PostCommentDTO toDto(PostComment postComment) {
        PostCommentDTO postCommentDTO = toDto(postComment, PostCommentDTO.class);
        if (postComment.getPost() != null) {
            postCommentDTO.setPostUuid(postComment.getPost().getUuid());
        }
        if (postComment.getChildComments() != null) {
            postCommentDTO.setChildCommentUuids(postComment.getChildComments().stream()
                    .map(PostComment::getUuid)
                    .collect(Collectors.toSet()));
        }
        if (postComment.getParentComment() != null) {
            postCommentDTO.setParentCommentUuid(postComment.getParentComment().getUuid());
        }
        return postCommentDTO;
    }

    public PostComment toEntity(PostCommentDTO postCommentDTO) {
        return toEntity(postCommentDTO, PostComment.class);
    }
}

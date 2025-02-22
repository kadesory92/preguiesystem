package banatech.gn.preguie_blogservice.service.comment;

import banatech.gn.preguie_blogservice.dto.PostCommentDTO;

import java.util.List;
import java.util.UUID;

public interface PostCommentService {
    PostCommentDTO createComment(PostCommentDTO postCommentDTO);

    PostCommentDTO getCommentById(UUID uuid);

    List<PostCommentDTO> getCommentsByPost(UUID postUuid);

    PostCommentDTO updateComment(UUID uuid, PostCommentDTO postCommentDTO);

    void deleteComment(UUID uuid);

    List<PostCommentDTO> getChildComments(UUID parentCommentUuid);
}

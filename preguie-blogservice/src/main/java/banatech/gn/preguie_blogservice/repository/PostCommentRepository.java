package banatech.gn.preguie_blogservice.repository;

import banatech.gn.preguie_blogservice.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostCommentRepository extends JpaRepository<PostComment, UUID> {
    List<PostComment> findByPostUuid(UUID postUuid);
    List<PostComment> findByParentCommentUuid(UUID parentCommentUuid);
}

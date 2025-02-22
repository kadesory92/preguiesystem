package banatech.gn.preguie_blogservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class PostComment extends BlogEntityId{
    private UUID userUuid;
    @ManyToOne
    @JoinColumn(name = "post_uuid") // Spécifie la colonne de jointure
    private Post post;
    private String title;
    private String description;
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostComment> childComments;
    @ManyToOne
    @JoinColumn(name = "parent_comment_uuid")
    private PostComment parentComment;

    public PostComment() {
    }

    public PostComment(UUID userUuid, Post post, String title, String description,
                       Set<PostComment> childComments, PostComment parentComment) {
        this.userUuid = userUuid;
        this.post = post;
        this.title = title;
        this.description = description;
        this.childComments = childComments;
        this.parentComment = parentComment;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PostComment> getChildComments() {
        return childComments;
    }

    public void setChildComments(Set<PostComment> childComments) {
        this.childComments = childComments;
    }

    public PostComment getParentComment() {
        return parentComment;
    }

    public void setParentComment(PostComment parentComment) {
        this.parentComment = parentComment;
    }
}

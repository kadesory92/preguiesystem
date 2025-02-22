package banatech.gn.preguie_blogservice.model;

import banatech.gn.preguie_blogservice.enums.TypeReaction;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Reaction extends BlogEntityId{
    private String type;

    @ManyToOne
    @JoinColumn(name = "post_uuid")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "post_comment_uuid")
    private PostComment postComment;

    @Enumerated(EnumType.STRING)
    private TypeReaction typeReaction;

    public Reaction() {
    }

    public Reaction(String type, Post post, PostComment postComment, TypeReaction typeReaction) {
        this.type = type;
        this.post = post;
        this.postComment = postComment;
        this.typeReaction = typeReaction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostComment getPostComment() {
        return postComment;
    }

    public void setPostComment(PostComment postComment) {
        this.postComment = postComment;
    }

    public TypeReaction getTypeReaction() {
        return typeReaction;
    }

    public void setTypeReaction(TypeReaction typeReaction) {
        this.typeReaction = typeReaction;
    }
}

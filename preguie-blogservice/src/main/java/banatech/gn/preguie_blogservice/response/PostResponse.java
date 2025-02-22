package banatech.gn.preguie_blogservice.response;

import banatech.gn.preguie_blogservice.dto.PostCommentDTO;
import banatech.gn.preguie_blogservice.dto.PostDTO;
import banatech.gn.preguie_blogservice.dto.ReactionDTO;

import java.util.List;

public class PostResponse {
    private PostDTO post; // Informations du post
    private List<PostCommentDTO> comments; // Liste des commentaires associés au post
    private List<ReactionDTO> reactions; // Liste des réactions associées au post

    // Getters et Setters
    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public List<PostCommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<PostCommentDTO> comments) {
        this.comments = comments;
    }

    public List<ReactionDTO> getReactions() {
        return reactions;
    }

    public void setReactions(List<ReactionDTO> reactions) {
        this.reactions = reactions;
    }
}

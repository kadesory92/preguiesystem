package banatech.gn.preguie_blogservice.dto;

import banatech.gn.preguie_blogservice.enums.TypeReaction;
import lombok.Data;

import java.util.UUID;

//@Data
public class ReactionDTO {
    private UUID uuid;
    private String type;
    private UUID postUuid; // Utilisation de l'UUID pour éviter la récursion
    private UUID postCommentUuid; // Utilisation de l'UUID pour éviter la récursion
    private TypeReaction typeReaction;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getPostUuid() {
        return postUuid;
    }

    public void setPostUuid(UUID postUuid) {
        this.postUuid = postUuid;
    }

    public UUID getPostCommentUuid() {
        return postCommentUuid;
    }

    public void setPostCommentUuid(UUID postCommentUuid) {
        this.postCommentUuid = postCommentUuid;
    }

    public TypeReaction getTypeReaction() {
        return typeReaction;
    }

    public void setTypeReaction(TypeReaction typeReaction) {
        this.typeReaction = typeReaction;
    }
}

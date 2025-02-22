package banatech.gn.preguie_blogservice.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

//@Data
public class PostCommentDTO {
    private UUID uuid;
    private UUID userUuid;
    private UUID postUuid; // Utilisation de l'UUID pour éviter la récursion
    private String title;
    private String description;
    private Set<UUID> childCommentUuids; // Utilisation des UUIDs pour éviter la récursion
    private UUID parentCommentUuid; // Utilisation de l'UUID pour éviter la récursion

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public UUID getPostUuid() {
        return postUuid;
    }

    public void setPostUuid(UUID postUuid) {
        this.postUuid = postUuid;
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

    public Set<UUID> getChildCommentUuids() {
        return childCommentUuids;
    }

    public void setChildCommentUuids(Set<UUID> childCommentUuids) {
        this.childCommentUuids = childCommentUuids;
    }

    public UUID getParentCommentUuid() {
        return parentCommentUuid;
    }

    public void setParentCommentUuid(UUID parentCommentUuid) {
        this.parentCommentUuid = parentCommentUuid;
    }
}

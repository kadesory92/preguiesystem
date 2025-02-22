package banatech.gn.preguie_blogservice.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

//@Data
public class PostDTO {
    private UUID uuid;
    private String title;
    private String slug;
    private String content;
    private LocalDate createAt;
    private UUID userUuid; // Identifiant de l'utilisateur
    private UserDTO user; // Informations de l'utilisateur (optionnel)
    private UUID categoryUuid;
    private Set<UUID> tagUuids;
    private Set<UUID> commentUuids;
    private Set<UUID> postFileUuids;
    private Set<UUID> reactionUuids;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UUID getCategoryUuid() {
        return categoryUuid;
    }

    public void setCategoryUuid(UUID categoryUuid) {
        this.categoryUuid = categoryUuid;
    }

    public Set<UUID> getTagUuids() {
        return tagUuids;
    }

    public void setTagUuids(Set<UUID> tagUuids) {
        this.tagUuids = tagUuids;
    }

    public Set<UUID> getCommentUuids() {
        return commentUuids;
    }

    public void setCommentUuids(Set<UUID> commentUuids) {
        this.commentUuids = commentUuids;
    }

    public Set<UUID> getPostFileUuids() {
        return postFileUuids;
    }

    public void setPostFileUuids(Set<UUID> postFileUuids) {
        this.postFileUuids = postFileUuids;
    }

    public Set<UUID> getReactionUuids() {
        return reactionUuids;
    }

    public void setReactionUuids(Set<UUID> reactionUuids) {
        this.reactionUuids = reactionUuids;
    }
}

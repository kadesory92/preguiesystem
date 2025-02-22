package banatech.gn.preguie_blogservice.dto;

import java.util.Set;
import java.util.UUID;
//@Data
public class TagDTO {
    private UUID uuid;
    private String title;
    private String slug;
    private String description;
    private Set<UUID> postUuids; // Utilisation des UUIDs pour éviter la récursion

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UUID> getPostUuids() {
        return postUuids;
    }

    public void setPostUuids(Set<UUID> postUuids) {
        this.postUuids = postUuids;
    }
}

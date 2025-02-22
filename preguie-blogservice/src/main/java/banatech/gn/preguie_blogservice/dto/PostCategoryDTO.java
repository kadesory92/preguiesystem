package banatech.gn.preguie_blogservice.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

public class PostCategoryDTO {
    private UUID uuid;
    private String name;
    private String description;
    private Set<UUID> postUuids; // Utilisation des UUIDs pour éviter la récursion

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

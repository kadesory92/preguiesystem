package banatech.gn.preguie_blogservice.model;

import jakarta.persistence.*;
import java.util.UUID;

@MappedSuperclass
public class BlogEntityId {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Utilisation de GenerationType.UUID
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
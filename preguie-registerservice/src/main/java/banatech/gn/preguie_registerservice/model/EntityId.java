package banatech.gn.preguie_registerservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public abstract class EntityId {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
}

package banatech.gn.preguie_blogservice.repository;

import banatech.gn.preguie_blogservice.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReactionRepository extends JpaRepository<Reaction, UUID> {
}

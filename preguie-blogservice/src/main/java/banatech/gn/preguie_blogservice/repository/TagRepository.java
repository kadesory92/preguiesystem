package banatech.gn.preguie_blogservice.repository;

import banatech.gn.preguie_blogservice.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}

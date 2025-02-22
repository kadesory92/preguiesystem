package banatech.gn.preguie_blogservice.repository;

import banatech.gn.preguie_blogservice.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostCategoryRepository extends JpaRepository<PostCategory, UUID> {
    boolean existsBySlug(String slug); // Vérifie si un slug existe déjà
}

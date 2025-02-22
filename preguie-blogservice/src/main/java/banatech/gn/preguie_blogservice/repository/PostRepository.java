package banatech.gn.preguie_blogservice.repository;

import banatech.gn.preguie_blogservice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    boolean existsBySlug(String slug);

    // Pagination simple
    Page<Post> findAll(Pageable pageable);

    // Filtrer par catégorie
    Page<Post> findByCategoryUuid(UUID categoryUuid, Pageable pageable);

    // Filtrer par tag
    @Query("SELECT p FROM Post p JOIN p.tags t WHERE t.uuid = :tagUuid")
    Page<Post> findByTagUuid(@Param("tagUuid") UUID tagUuid, Pageable pageable);

    // Filtrer par statut de publication (exemple : statut = "PUBLISHED")
//    Page<Post> findByStatus(String status, Pageable pageable);

    // Combinaison de filtres (catégorie + statut)
//    Page<Post> findByCategoryUuidAndStatus(UUID categoryUuid, String status, Pageable pageable);

}

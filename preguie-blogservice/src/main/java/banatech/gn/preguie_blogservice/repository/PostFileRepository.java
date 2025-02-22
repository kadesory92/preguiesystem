package banatech.gn.preguie_blogservice.repository;

import banatech.gn.preguie_blogservice.model.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostFileRepository extends JpaRepository<PostFile, UUID> {
}

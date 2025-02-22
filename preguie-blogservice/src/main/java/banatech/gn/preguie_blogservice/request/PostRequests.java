package banatech.gn.preguie_blogservice.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public class PostRequests {
    private UUID categoryUuid;
    private String title;
    private String content;
    private List<MultipartFile> files; // Liste des fichiers à uploader

    // Getters et setters
}

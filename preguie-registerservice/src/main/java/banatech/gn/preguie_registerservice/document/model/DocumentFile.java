package banatech.gn.preguie_registerservice.model;

import banatech.gn.preguie_registerservice.document.enums.TypeFile;
import jakarta.persistence.Entity;

@Entity
public class DocumentFile extends EntityId {
    private String name;
    private String url;
    private TypeFile typeFile;
    private int fileSize;
}

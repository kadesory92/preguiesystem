package banatech.gn.preguie_registerservice.registre.model;

import banatech.gn.preguie_registerservice.enums.TypeDocument;
import banatech.gn.preguie_registerservice.model.DocumentFile;
import banatech.gn.preguie_registerservice.model.EntityId;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Document extends EntityId {
    private TypeDocument typeDocument;
    private String name;
    private LocalDate dateOfIssue;
    private LocalDate dateOfExpiry;
    @OneToOne
    private DocumentFile documentFile;
}

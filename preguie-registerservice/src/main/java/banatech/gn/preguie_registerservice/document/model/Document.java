package banatech.gn.preguie_registerservice.document.model;

import banatech.gn.preguie_registerservice.document.enums.TypeDocument;
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
    private String typeVisa;
    private String typePassport;
}

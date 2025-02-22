package banatech.gn.preguie_registerservice.document.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeDocument {
    PASSPORT(0, "Passport"),
    BIRTH_CERTIFICATE(1, "Certificat de naissance"),
    NATIONAL_IDENTITY_CARD(3, "Carte d'Identité Nationale"),
    DIPLOMA(4, "Diplôme"),
    VISAS(5, "Visa"),
    TRANSCRIPT_GRADES(6, "Relevé de notes"),
    CERTIFICATE(7, "Certificat"),
    CV(8, "Curriculum Vitae"),
    OTHER(9, "Autre...");

    private final int value;
    private final String title;

    TypeDocument(final int value, final String title){
        this.value = value;
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }
}

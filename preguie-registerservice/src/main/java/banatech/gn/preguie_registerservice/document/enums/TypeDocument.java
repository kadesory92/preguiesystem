package banatech.gn.preguie_registerservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeDocument {
    PASSPORT(0, "Passport"),
    BIRTH_CERTIFICATE(1, "Certificat de naissance"),
    NATIONAL_IDENTITY_CARD(3, "Carte d'Identité Nationale"),
    DIPLOMA(4, "Diplôme"),
    TRANSCRIPT_GRADES(5, "Relevé de notes"),
    CERTIFICATE(6, "Certificat"),
    CV(7, "Curriculum Vitae"),
    OTHER(8, "Autre...");

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

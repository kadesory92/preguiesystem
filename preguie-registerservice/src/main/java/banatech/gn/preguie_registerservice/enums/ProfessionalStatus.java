package banatech.gn.preguie_registerservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProfessionalStatus {
    INTERN(0, "Titutaire"),
    STATE_OFFICIAL(1, "Fonctionnaire d'Etat");

    private final int value;
    private final String title;

    ProfessionalStatus(int value, String title){
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
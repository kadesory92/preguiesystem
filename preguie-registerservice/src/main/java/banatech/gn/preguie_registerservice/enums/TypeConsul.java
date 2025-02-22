package banatech.gn.preguie_registerservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeConsul {
    CONSULATE(0, "Consulat"),
    GENERALE_CONSULATE(1, "Consulat Général");

    private int value;
    private String title;

    TypeConsul(int value, String title) {
        this.value = value;
        this.title = title;
    }
}

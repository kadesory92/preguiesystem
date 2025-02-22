package banatech.gn.preguie_registerservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PositionStaff {

    AMBASSADOR(0, "Ambassadeur"),
    CONSUL_GENERAL(1, "Consul Général"),
    CONSUL(2, "Consul"),
    SECRETARY(3, "Secrétaire"),
    POLITICAL_ADVISOR(4, "Conseiller Politique"),
    HEAD_OF_CONSULAR_AFFAIRS(5, "Chargé des Affaires Consulaires"),
    RESPONSIBLE_FOR_THE_PROTOCOL(6, "Chargé du protocol"),
    RESPONSIBLE_FOR_CULTURAL_AFFAIRS(7, "Chargé des Affaires Culturelles");

     private int value;
     private String title;

    PositionStaff(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public String getName(){
        return name();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

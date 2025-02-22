package banatech.gn.preguie_registerservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProfileUser {
    STUDENT(0, "Etudiant"),
    RESIDENT_EXPATRIATE(1, "Expatrié résident"),
    IRREGULAR_EXPATRIATE(2, "Expatrié en situation Irregulière"),
    TOURIST(3, "Touriste"),
    MILITARY_PERSONNEL(4, "Personnel militaire"),
    DIPLOMATIC_STAFF(5, "Personnel Diplomatique");

    private final int value;
    private final String title;

    ProfileUser(int value, String title) {
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

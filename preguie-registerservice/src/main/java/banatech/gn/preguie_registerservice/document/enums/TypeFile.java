package banatech.gn.preguie_registerservice.document.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeFile {
    DOCUMENT(0, "Document"),
    IMAGE(1, "Image"),
    VIDEO(2, "Vidéo");

    private final int value;
    private final String title;

    TypeFile(int value, String title){
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

package banatech.gn.preguie_registerservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeFile {
    DOCUMENT(0, "Document"),
    IMAGE(1, "Image"),
    VIDEO(2, "Vidéo");

    private int value;
    private String title;

    TypeFile(int value, String title){
        this.value = value;
        this.title = title;
    }
}

package banatech.gn.preguie_registerservice.document.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Extension {
    PDF(0, ".doc"),
    DOC(1, ".docx"),
    DOCX(2, ".pdf"),
    XLS(3, ".xls"),
    XLSX(4, ".xlsx"),
    PPTX(5, ".pptx"),
    PNG(6, ".png"),
    JPG(7, ".jpg"),
    JPEG(8, ".jpeg"),
    GIF(9, ".gif"),
    MP3(10, ".mp3"),
    MP4(11, ".mp4"),
    WAV(12, ".wav"),
    AAC(13, ".aac"),
    AVI(14, ".avi");

    private final int value;
    private final String title;

    Extension(final int value, final String title){
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

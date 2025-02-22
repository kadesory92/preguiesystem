package banatech.gn.preguie_registerservice.document.model;

import banatech.gn.preguie_registerservice.document.enums.TypeFile;
import banatech.gn.preguie_registerservice.model.EntityId;
import jakarta.persistence.Entity;

@Entity
public class DocumentFile extends EntityId {
    private String name;
    private String url;
    private TypeFile typeFile;
    private Exception exception;
    private int fileSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TypeFile getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(TypeFile typeFile) {
        this.typeFile = typeFile;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
}

package banatech.gn.preguie_blogservice.dto;

import lombok.Data;

import java.util.UUID;

//@Data
public class PostFileDTO {
    private UUID uuid;
    private String fileName;
    private String fileUrl;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}

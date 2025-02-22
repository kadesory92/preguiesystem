package banatech.gn.preguie_blogservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class PostFile extends BlogEntityId{
    private String fileName;
    private String fileUrl;
    @ManyToOne
    @JoinColumn(name = "post_uuid")
    private Post post;

    public PostFile() {
    }

    public PostFile(String fileName, String fileUrl, Post post) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.post = post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

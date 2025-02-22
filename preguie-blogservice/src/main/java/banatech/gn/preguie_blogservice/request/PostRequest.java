package banatech.gn.preguie_blogservice.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PostRequest {
    private UUID categoryUuid;
    private String title;
    private String content;
//    private Set<UUID> postFileUuids;
//    private List<String> fileNames;
private List<MultipartFile> files;

    public UUID getCategoryUuid() {
        return categoryUuid;
    }

    public void setCategoryUuid(UUID categoryUuid) {
        this.categoryUuid = categoryUuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public Set<UUID> getPostFileUuids() {
//        return postFileUuids;
//    }
//
//    public void setPostFileUuids(Set<UUID> postFileUuids) {
//        this.postFileUuids = postFileUuids;
//    }

//    public List<String> getFileNames() {
//        return fileNames;
//    }
//
//    public void setFileNames(List<String> fileNames) {
//        this.fileNames = fileNames;
//    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}

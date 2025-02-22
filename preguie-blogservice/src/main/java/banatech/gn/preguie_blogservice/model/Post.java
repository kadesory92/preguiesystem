package banatech.gn.preguie_blogservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
//@Getter @Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Post extends BlogEntityId{
    private String title;
    private String slug;
    private String content;
    private LocalDate createAt;
    private UUID userUuid;

    @ManyToOne
    @JoinColumn(name = "category_uuid")
    private PostCategory category;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_uuid"),
            inverseJoinColumns = @JoinColumn(name = "tag_uuid")
    )
    private Set<Tag> tags;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostComment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostFile> postFiles;

//    @ElementCollection
//    @CollectionTable(name = "post_files", joinColumns = @JoinColumn(name = "post_uuid"))
//    @Column(name = "file_uuid")
//    private Set<UUID> postFiles;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reaction> reactions;

    public Post() {
    }

    public Post(String title, String slug, String content, LocalDate createAt, PostCategory category,
                Set<Tag> tags, Set<PostComment> comments, Set<PostFile> postFiles, Set<Reaction> reactions) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.createAt = createAt;
        this.category = category;
        this.tags = tags;
        this.comments = comments;
        this.postFiles = postFiles;
        this.reactions = reactions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public PostCategory getCategory() {
        return category;
    }

    public void setCategory(PostCategory category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<PostComment> getComments() {
        return comments;
    }

    public void setComments(Set<PostComment> comments) {
        this.comments = comments;
    }

    public Set<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(Set<Reaction> reactions) {
        this.reactions = reactions;
    }

    public Set<PostFile> getPostFiles() {
        return postFiles;
    }

    public void setPostFiles(Set<PostFile> postFiles) {
        this.postFiles = postFiles;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }
}
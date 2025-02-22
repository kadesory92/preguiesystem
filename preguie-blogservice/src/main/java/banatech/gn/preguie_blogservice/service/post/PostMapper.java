package banatech.gn.preguie_blogservice.service.post;

import banatech.gn.preguie_blogservice.dto.PostCategoryDTO;
import banatech.gn.preguie_blogservice.dto.PostDTO;
import banatech.gn.preguie_blogservice.model.*;
import banatech.gn.preguie_blogservice.service.EntityMapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PostMapper extends EntityMapper {

    public PostDTO toDto(Post post) {
        PostDTO postDTO = toDto(post, PostDTO.class);
        if (post.getCategory() != null) {
            postDTO.setCategoryUuid(post.getCategory().getUuid());
        }
        if (post.getTags() != null) {
            postDTO.setTagUuids(post.getTags().stream().map(Tag::getUuid).collect(Collectors.toSet()));
        }
        if (post.getComments() != null) {
            postDTO.setCommentUuids(post.getComments().stream().map(PostComment::getUuid).collect(Collectors.toSet()));
        }
        if (post.getPostFiles() != null) {
//            Set<UUID> postFileUuids = post.getPostFiles().stream().map(PostFile::getUuid).collect(Collectors.toSet());
            postDTO.setPostFileUuids(post.getPostFiles().stream()
                    .map(PostFile::getUuid).collect(Collectors.toSet()));
        }
        if (post.getReactions() != null) {
            postDTO.setReactionUuids(post.getReactions().stream().map(Reaction::getUuid).collect(Collectors.toSet()));
        }
        return postDTO;
    }

    public Post toEntity(PostDTO postDTO) {
        return toEntity(postDTO, Post.class);
    }

    // Mapper une Page<Post> vers une Page<PostDTO>
    public Page<PostDTO> toDtoPage(Page<Post> postPage) {
        return postPage.map(this::toDto);
    }
}

package banatech.gn.preguie_blogservice.service.category;

import banatech.gn.preguie_blogservice.dto.PostCategoryDTO;
import banatech.gn.preguie_blogservice.model.Post;
import banatech.gn.preguie_blogservice.model.PostCategory;
import banatech.gn.preguie_blogservice.service.EntityMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PostCategoryMapper extends EntityMapper {

    public PostCategoryDTO toDto(PostCategory postCategory) {
        PostCategoryDTO postCategoryDTO = toDto(postCategory, PostCategoryDTO.class);
        if (postCategory.getPosts() != null) {
            postCategoryDTO.setPostUuids(postCategory.getPosts().stream().map(Post::getUuid).collect(Collectors.toSet()));
        }
        return postCategoryDTO;
    }

    public PostCategory toEntity(PostCategoryDTO postCategoryDTO) {
        return toEntity(postCategoryDTO, PostCategory.class);
    }
}

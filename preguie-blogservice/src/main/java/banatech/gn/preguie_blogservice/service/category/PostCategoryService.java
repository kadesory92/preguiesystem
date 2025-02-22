package banatech.gn.preguie_blogservice.service.category;

import banatech.gn.preguie_blogservice.dto.PostCategoryDTO;
import banatech.gn.preguie_blogservice.request.PostCategoryRequest;

import java.util.List;
import java.util.UUID;

public interface PostCategoryService {
    String createPostCategory(PostCategoryRequest request);
    List<PostCategoryDTO> getAllCategories();
    PostCategoryDTO getPostCategory(UUID uuid);
    PostCategoryDTO updatePostCategory(UUID uuid, PostCategoryDTO postCategoryDTO);
    void deletePostCategory(UUID uuid);
}

package banatech.gn.preguie_blogservice.service.category;

import banatech.gn.preguie_blogservice.dto.PostCategoryDTO;
import banatech.gn.preguie_blogservice.model.Post;
import banatech.gn.preguie_blogservice.model.PostCategory;
import banatech.gn.preguie_blogservice.repository.PostCategoryRepository;
import banatech.gn.preguie_blogservice.request.PostCategoryRequest;
import banatech.gn.preguie_blogservice.utils.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostCategoryServiceImpl implements PostCategoryService{
    @Autowired
    private PostCategoryRepository postCategoryRepository;
    @Autowired
    private PostCategoryMapper postCategoryMapper;
    @Override
    public String createPostCategory(PostCategoryRequest request) {
        PostCategory postCategory = new PostCategory();
        String baseSlug = SlugUtil.generateSlug(request.getName());
        String uniqueSlug = SlugUtil.createUniqueNameSlug(
                baseSlug, slug -> postCategoryRepository.existsBySlug(slug));

        postCategory.setName(request.getName());
        postCategory.setSlug(uniqueSlug);
        postCategory.setDescription(request.getDescription());

       postCategoryRepository.save(postCategory);
       return "Post category created successfully !";
    }

    @Override
    public List<PostCategoryDTO> getAllCategories() {
        List<PostCategory> categories = postCategoryRepository.findAll();
        return categories.stream()
                .map(postCategory -> postCategoryMapper.toDto(postCategory)).collect(Collectors.toList());
    }

    @Override
    public PostCategoryDTO getPostCategory(UUID uuid) {
        PostCategory postCategory = postCategoryRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return postCategoryMapper.toDto(postCategory);
    }

    @Override
    public PostCategoryDTO updatePostCategory(UUID uuid, PostCategoryDTO postCategoryDTO) {
        PostCategory existingPostCategory = postCategoryRepository
                .findById(uuid).orElseThrow(() -> new RuntimeException("Category not found"));
        postCategoryMapper.updateEntityFromDto(postCategoryDTO, existingPostCategory);
        PostCategory updatedPostCategory = postCategoryRepository.save(existingPostCategory);
        return postCategoryMapper.toDto(updatedPostCategory);
    }

    @Override
    public void deletePostCategory(UUID uuid) {
        postCategoryRepository.deleteById(uuid);
    }
}

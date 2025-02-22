package banatech.gn.preguie_blogservice.service.post;

import banatech.gn.preguie_blogservice.dto.PostDTO;
import banatech.gn.preguie_blogservice.request.PostRequest;
import banatech.gn.preguie_blogservice.response.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PostService {
    PostDTO createPost(PostRequest request);
    List<PostDTO> getAllPost();
    PostDTO getPost(UUID uuid);
    PostDTO updatePost(UUID uuid, PostRequest request);
    void deletePost(UUID uuid);
    List<PostResponse> getAllPostWithComments();
    PostResponse getPostWithComments(UUID uuid);
    PostResponse getPostWithReaction(UUID uuid);

    // Pagination et filtrage
    Page<PostDTO> getAllPosts(Pageable pageable);
    Page<PostDTO> getPostsByCategory(UUID categoryUuid, Pageable pageable);
    Page<PostDTO> getPostsByTag(UUID tagUuid, Pageable pageable);
//    Page<PostDTO> getPostsByStatus(String status, Pageable pageable);
//    Page<PostDTO> getPostsByCategoryAndStatus(UUID categoryUuid, String status, Pageable pageable);
}

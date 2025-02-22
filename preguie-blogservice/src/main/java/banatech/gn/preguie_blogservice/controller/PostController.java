package banatech.gn.preguie_blogservice.controller;

import banatech.gn.preguie_blogservice.dto.PostDTO;
import banatech.gn.preguie_blogservice.request.PostRequest;
import banatech.gn.preguie_blogservice.response.PostResponse;
import banatech.gn.preguie_blogservice.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Créer un nouveau post
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostRequest request) {
        PostDTO postDTO = postService.createPost(request);
        return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
    }

    // Récupérer tous les posts (sans pagination)
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.getAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Récupérer un post par son UUID
    @GetMapping("/{uuid}")
    public ResponseEntity<PostDTO> getPost(@PathVariable UUID uuid) {
        PostDTO postDTO = postService.getPost(uuid);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    // Mettre à jour un post
    @PutMapping("/{uuid}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable UUID uuid, @RequestBody PostRequest request) {
        PostDTO postDTO = postService.updatePost(uuid, request);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    // Supprimer un post
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID uuid) {
        postService.deletePost(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Récupérer tous les posts avec leurs commentaires (sans pagination)
    @GetMapping("/with-comments")
    public ResponseEntity<List<PostResponse>> getAllPostsWithComments() {
        List<PostResponse> posts = postService.getAllPostWithComments();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Récupérer un post avec ses commentaires par son UUID
    @GetMapping("/{uuid}/with-comments")
    public ResponseEntity<PostResponse> getPostWithComments(@PathVariable UUID uuid) {
        PostResponse postResponse = postService.getPostWithComments(uuid);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // Récupérer un post avec ses réactions par son UUID
    @GetMapping("/{uuid}/with-reactions")
    public ResponseEntity<PostResponse> getPostWithReactions(@PathVariable UUID uuid) {
        PostResponse postResponse = postService.getPostWithReaction(uuid);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    // Récupérer tous les posts avec pagination
    @GetMapping("/paginated")
    public ResponseEntity<Page<PostDTO>> getAllPostsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostDTO> posts = postService.getAllPosts(pageable);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Récupérer les posts par catégorie avec pagination
    @GetMapping("/category/{categoryUuid}")
    public ResponseEntity<Page<PostDTO>> getPostsByCategory(
            @PathVariable UUID categoryUuid,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostDTO> posts = postService.getPostsByCategory(categoryUuid, pageable);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Récupérer les posts par tag avec pagination
    @GetMapping("/tag/{tagUuid}")
    public ResponseEntity<Page<PostDTO>> getPostsByTag(
            @PathVariable UUID tagUuid,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostDTO> posts = postService.getPostsByTag(tagUuid, pageable);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Récupérer les posts par statut avec pagination
//    @GetMapping("/status/{status}")
//    public ResponseEntity<Page<PostDTO>> getPostsByStatus(
//            @PathVariable String status,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<PostDTO> posts = postService.getPostsByStatus(status, pageable);
//        return new ResponseEntity<>(posts, HttpStatus.OK);
//    }

    // Récupérer les posts par catégorie et statut avec pagination
//    @GetMapping("/category/{categoryUuid}/status/{status}")
//    public ResponseEntity<Page<PostDTO>> getPostsByCategoryAndStatus(
//            @PathVariable UUID categoryUuid,
//            @PathVariable String status,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<PostDTO> posts = postService.getPostsByCategoryAndStatus(categoryUuid, status, pageable);
//        return new ResponseEntity<>(posts, HttpStatus.OK);
//    }
}
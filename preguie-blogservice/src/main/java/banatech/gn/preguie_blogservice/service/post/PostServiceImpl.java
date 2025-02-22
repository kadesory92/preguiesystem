package banatech.gn.preguie_blogservice.service.post;

import banatech.gn.preguie_blogservice.dto.PostDTO;
import banatech.gn.preguie_blogservice.exception.ResourceNotFoundException;
import banatech.gn.preguie_blogservice.model.Post;
import banatech.gn.preguie_blogservice.model.PostCategory;
import banatech.gn.preguie_blogservice.model.PostComment;
import banatech.gn.preguie_blogservice.model.PostFile;
import banatech.gn.preguie_blogservice.repository.*;
import banatech.gn.preguie_blogservice.request.PostRequest;
import banatech.gn.preguie_blogservice.response.PostResponse;
import banatech.gn.preguie_blogservice.service.FileStorageService;
import banatech.gn.preguie_blogservice.service.comment.PostCommentMapper;
import banatech.gn.preguie_blogservice.service.reaction.ReactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostFileRepository postFileRepository;

    @Autowired
    private PostCommentMapper postCommentMapper;

    @Autowired
    private ReactionMapper reactionMapper;

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Autowired
    private ReactionRepository reactionRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public PostDTO createPost(PostRequest request) {
        if (request.getCategoryUuid() == null) {
            throw new IllegalArgumentException("Category UUID cannot be null");
        }

        PostCategory postCategory = postCategoryRepository.findById(request.getCategoryUuid())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with UUID: " + request.getCategoryUuid()));

        Post post = new Post();
        post.setCategory(postCategory);
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCreateAt(LocalDate.now());

        // Gestion des fichiers
        if (request.getFiles() != null && !request.getFiles().isEmpty()) {
            Set<PostFile> postFiles = request.getFiles().stream()
                    .map(file -> {
                        String fileName = fileStorageService.storeFile(file); // Stocker le fichier sur le disque
                        PostFile postFile = new PostFile();
                        postFile.setFileName(fileName);
                        postFile.setFileUrl("/uploads/" + fileName); // URL du fichier
                        postFile.setPost(post); // Associer le fichier au post
                        return postFileRepository.save(postFile); // Sauvegarder le fichier en base de données
                    })
                    .collect(Collectors.toSet());
            post.setPostFiles(postFiles);
        }

        Post postSaved = postRepository.save(post);
        return postMapper.toDto(postSaved);
    }

    @Override
    public List<PostDTO> getAllPost() {
        return postRepository.findAll().stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPost(UUID uuid) {
        Post post = postRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with UUID: " + uuid));
        return postMapper.toDto(post);
    }

    @Override
    public PostDTO updatePost(UUID uuid, PostRequest request) {
        Post post = postRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with UUID: " + uuid));

        if (request.getCategoryUuid() != null) {
            PostCategory postCategory = postCategoryRepository.findById(request.getCategoryUuid())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with UUID: " + request.getCategoryUuid()));
            post.setCategory(postCategory);
        }

        if (request.getTitle() != null) {
            post.setTitle(request.getTitle());
        }

        if (request.getContent() != null) {
            post.setContent(request.getContent());
        }

        // Gestion des fichiers
        if (request.getFiles() != null && !request.getFiles().isEmpty()) {
            // Supprimer les fichiers existants
            post.getPostFiles().forEach(postFile -> {
                try {
                    Files.deleteIfExists(fileStorageService.getFileStorageLocation().resolve(postFile.getFileName()));
                } catch (IOException e) {
                    throw new RuntimeException("Failed to delete file: " + postFile.getFileName(), e);
                }
                postFileRepository.delete(postFile);
            });
            post.getPostFiles().clear();

            // Ajouter les nouveaux fichiers
            Set<PostFile> postFiles = request.getFiles().stream()
                    .map(file -> {
                        String fileName = fileStorageService.storeFile(file); // Stocker le fichier sur le disque
                        PostFile postFile = new PostFile();
                        postFile.setFileName(fileName);
                        postFile.setFileUrl("/uploads/" + fileName); // URL du fichier
                        postFile.setPost(post); // Associer le fichier au post
                        return postFileRepository.save(postFile); // Sauvegarder le fichier en base de données
                    })
                    .collect(Collectors.toSet());
            post.setPostFiles(postFiles);
        }

        Post updatedPost = postRepository.save(post);
        return postMapper.toDto(updatedPost);
    }

    @Override
    public void deletePost(UUID uuid) {
        Post post = postRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with UUID: " + uuid));
        postRepository.delete(post);
    }

    @Override
    public List<PostResponse> getAllPostWithComments() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(this::mapToPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostWithComments(UUID uuid) {
        Post post = postRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with UUID: " + uuid));
        return mapToPostResponse(post);
    }

    @Override
    public PostResponse getPostWithReaction(UUID uuid) {
        Post post = postRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with UUID: " + uuid));
        return mapToPostResponseWithReactions(post);
    }

    @Override
    public Page<PostDTO> getAllPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.map(postMapper::toDto);
    }

    @Override
    public Page<PostDTO> getPostsByCategory(UUID categoryUuid, Pageable pageable) {
        Page<Post> posts = postRepository.findByCategoryUuid(categoryUuid, pageable);
        return posts.map(postMapper::toDto);
    }

    @Override
    public Page<PostDTO> getPostsByTag(UUID tagUuid, Pageable pageable) {
        Page<Post> posts = postRepository.findByTagUuid(tagUuid, pageable);
        return posts.map(postMapper::toDto);
    }

//    @Override
//    public Page<PostDTO> getPostsByStatus(String status, Pageable pageable) {
//        return null;
//    }

//    @Override
//    public Page<PostDTO> getPostsByCategoryAndStatus(UUID categoryUuid, String status, Pageable pageable) {
//        Page<Post> posts = postRepository.findByCategoryUuidAndStatus(categoryUuid, status, pageable);
//        return posts.map(postMapper::toDto);
//    }

    private PostResponse mapToPostResponse(Post post) {
        PostResponse response = new PostResponse();
        response.setPost(postMapper.toDto(post));
//        List<PostComment> postComments = postCommentRepository.findByPostUuid()
        response.setComments(postCommentRepository.findByPostUuid(post.getUuid()).stream()
                .map(postComment -> postCommentMapper.toDto(postComment))
                .collect(Collectors.toList()));
        return response;
    }

    private PostResponse mapToPostResponseWithReactions(Post post) {
        PostResponse response = new PostResponse();
        response.setPost(postMapper.toDto(post));
        response.setReactions(reactionRepository.findByPostUuid(post.getUuid()).stream()
                .map(reaction -> reactionMapper.toDto(reaction))
                .collect(Collectors.toList()));
        return response;
    }
}

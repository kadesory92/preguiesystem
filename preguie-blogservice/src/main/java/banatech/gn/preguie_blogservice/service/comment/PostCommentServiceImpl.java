package banatech.gn.preguie_blogservice.service.comment;

import banatech.gn.preguie_blogservice.dto.PostCommentDTO;
import banatech.gn.preguie_blogservice.exception.ResourceNotFoundException;
import banatech.gn.preguie_blogservice.model.Post;
import banatech.gn.preguie_blogservice.model.PostComment;
import banatech.gn.preguie_blogservice.repository.PostCommentRepository;
import banatech.gn.preguie_blogservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostCommentServiceImpl implements PostCommentService {

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentMapper postCommentMapper;

    @Override
    public PostCommentDTO createComment(PostCommentDTO postCommentDTO) {
        // Validation des données
        if (postCommentDTO.getPostUuid() == null) {
            throw new IllegalArgumentException("Post UUID cannot be null");
        }

        // Vérifier que le post existe
        Post post = postRepository.findById(postCommentDTO.getPostUuid())
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with UUID: " + postCommentDTO.getPostUuid()));

        // Vérifier que le commentaire parent existe (si spécifié)
        PostComment parentComment = null;
        if (postCommentDTO.getParentCommentUuid() != null) {
            parentComment = postCommentRepository.findById(postCommentDTO.getParentCommentUuid())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent comment not found with UUID: " + postCommentDTO.getParentCommentUuid()));
        }

        // Créer l'entité PostComment
        PostComment postComment = new PostComment();
        postComment.setPost(post);
        postComment.setUserUuid(postCommentDTO.getUserUuid());
        postComment.setTitle(postCommentDTO.getTitle());
        postComment.setDescription(postCommentDTO.getDescription());
        postComment.setParentComment(parentComment);

        // Sauvegarder le commentaire
        PostComment savedComment = postCommentRepository.save(postComment);

        // Retourner le DTO
        return postCommentMapper.toDto(savedComment);
    }

    @Override
    public PostCommentDTO getCommentById(UUID uuid) {
        PostComment postComment = postCommentRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with UUID: " + uuid));
        return postCommentMapper.toDto(postComment);
    }

    @Override
    public List<PostCommentDTO> getCommentsByPost(UUID postUuid) {
        // Vérifier que le post existe
        if (!postRepository.existsById(postUuid)) {
            throw new ResourceNotFoundException("Post not found with UUID: " + postUuid);
        }

        // Récupérer les commentaires associés au post
        List<PostComment> comments = postCommentRepository.findByPostUuid(postUuid);
        return comments.stream()
                .map(postComment -> postCommentMapper.toDto(postComment)).collect(Collectors.toList());
    }

    @Override
    public PostCommentDTO updateComment(UUID uuid, PostCommentDTO postCommentDTO) {
        // Vérifier que le commentaire existe
        PostComment postComment = postCommentRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with UUID: " + uuid));

        // Mettre à jour les champs si fournis
        if (postCommentDTO.getTitle() != null) {
            postComment.setTitle(postCommentDTO.getTitle());
        }
        if (postCommentDTO.getDescription() != null) {
            postComment.setDescription(postCommentDTO.getDescription());
        }

        // Sauvegarder les modifications
        PostComment updatedComment = postCommentRepository.save(postComment);
        return postCommentMapper.toDto(updatedComment);
    }

    @Override
    public void deleteComment(UUID uuid) {
        // Vérifier que le commentaire existe
        PostComment postComment = postCommentRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with UUID: " + uuid));

        // Supprimer le commentaire
        postCommentRepository.delete(postComment);
    }

    @Override
    public List<PostCommentDTO> getChildComments(UUID parentCommentUuid) {
        // Vérifier que le commentaire parent existe
        if (!postCommentRepository.existsById(parentCommentUuid)) {
            throw new ResourceNotFoundException("Parent comment not found with UUID: " + parentCommentUuid);
        }

        // Récupérer les commentaires enfants
        List<PostComment> childComments = postCommentRepository.findByParentCommentUuid(parentCommentUuid);
        return childComments.stream()
                .map(comment -> postCommentMapper.toDto(comment)).collect(Collectors.toList());
    }
}

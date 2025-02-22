package banatech.gn.preguie_blogservice.service.tag;

import banatech.gn.preguie_blogservice.dto.PostDTO;
import banatech.gn.preguie_blogservice.dto.TagDTO;
import banatech.gn.preguie_blogservice.exception.ResourceNotFoundException;
import banatech.gn.preguie_blogservice.model.Post;
import banatech.gn.preguie_blogservice.model.Tag;
import banatech.gn.preguie_blogservice.repository.PostRepository;
import banatech.gn.preguie_blogservice.repository.TagRepository;
import banatech.gn.preguie_blogservice.service.post.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private PostMapper postMapper;

    @Override
    public TagDTO createTag(TagDTO tagDTO) {
        // Validation des données
        if (tagDTO.getTitle() == null || tagDTO.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Tag title cannot be null or empty");
        }

        // Créer l'entité Tag
        Tag tag = new Tag();
        tag.setTitle(tagDTO.getTitle());
        tag.setSlug(tagDTO.getSlug());
        tag.setDescription(tagDTO.getDescription());

        // Sauvegarder le tag
        Tag savedTag = tagRepository.save(tag);

        // Retourner le DTO
        return tagMapper.toDto(savedTag);
    }

    @Override
    public TagDTO getTagById(UUID uuid) {
        Tag tag = tagRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with UUID: " + uuid));
        return tagMapper.toDto(tag);
    }

    @Override
    public List<TagDTO> getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream().map(tag -> tagMapper.toDto(tag)).collect(Collectors.toList());
    }

    @Override
    public TagDTO updateTag(UUID uuid, TagDTO tagDTO) {
        // Vérifier que le tag existe
        Tag tag = tagRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with UUID: " + uuid));

        // Mettre à jour les champs si fournis
        if (tagDTO.getTitle() != null) {
            tag.setTitle(tagDTO.getTitle());
        }
        if (tagDTO.getSlug() != null) {
            tag.setSlug(tagDTO.getSlug());
        }
        if (tagDTO.getDescription() != null) {
            tag.setDescription(tagDTO.getDescription());
        }

        // Sauvegarder les modifications
        Tag updatedTag = tagRepository.save(tag);
        return tagMapper.toDto(updatedTag);
    }

    @Override
    public void deleteTag(UUID uuid) {
        // Vérifier que le tag existe
        Tag tag = tagRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with UUID: " + uuid));

        // Supprimer le tag
        tagRepository.delete(tag);
    }

    @Override
    public List<PostDTO> getPostsByTag(UUID tagUuid) {
        // Vérifier que le tag existe
        Tag tag = tagRepository.findById(tagUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with UUID: " + tagUuid));

        // Récupérer les posts associés au tag
        List<Post> posts = tag.getPosts();
        return posts.stream()
                .map(post -> postMapper.toDto(post)).collect(Collectors.toList());
    }

    @Override
    public TagDTO addPostToTag(UUID tagUuid, UUID postUuid) {
        // Vérifier que le tag existe
        Tag tag = tagRepository.findById(tagUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with UUID: " + tagUuid));

        // Vérifier que le post existe
        Post post = postRepository.findById(postUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with UUID: " + postUuid));

        // Ajouter le post au tag
        tag.getPosts().add(post);
        post.getTags().add(tag);

        // Sauvegarder les modifications
        tagRepository.save(tag);
        postRepository.save(post);

        // Retourner le DTO du tag mis à jour
        return tagMapper.toDto(tag);
    }

    @Override
    public TagDTO removePostFromTag(UUID tagUuid, UUID postUuid) {
        // Vérifier que le tag existe
        Tag tag = tagRepository.findById(tagUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with UUID: " + tagUuid));

        // Vérifier que le post existe
        Post post = postRepository.findById(postUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with UUID: " + postUuid));

        // Retirer le post du tag
        tag.getPosts().remove(post);
        post.getTags().remove(tag);

        // Sauvegarder les modifications
        tagRepository.save(tag);
        postRepository.save(post);

        // Retourner le DTO du tag mis à jour
        return tagMapper.toDto(tag);
    }
}

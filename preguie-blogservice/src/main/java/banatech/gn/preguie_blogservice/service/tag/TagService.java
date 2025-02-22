package banatech.gn.preguie_blogservice.service.tag;

import banatech.gn.preguie_blogservice.dto.PostDTO;
import banatech.gn.preguie_blogservice.dto.TagDTO;

import java.util.List;
import java.util.UUID;

public interface TagService {

    TagDTO createTag(TagDTO tagDTO);

    TagDTO getTagById(UUID uuid);

    List<TagDTO> getAllTags();

    TagDTO updateTag(UUID uuid, TagDTO tagDTO);

    void deleteTag(UUID uuid);

    List<PostDTO> getPostsByTag(UUID tagUuid);

    TagDTO addPostToTag(UUID tagUuid, UUID postUuid);

    TagDTO removePostFromTag(UUID tagUuid, UUID postUuid);
}

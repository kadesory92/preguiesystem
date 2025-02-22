package banatech.gn.preguie_blogservice.service.tag;

import banatech.gn.preguie_blogservice.dto.TagDTO;
import banatech.gn.preguie_blogservice.model.Post;
import banatech.gn.preguie_blogservice.model.Tag;
import banatech.gn.preguie_blogservice.service.EntityMapper;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TagMapper extends EntityMapper {

    public TagDTO toDto(Tag tag) {
        TagDTO tagDTO = toDto(tag, TagDTO.class);
        if (tag.getPosts() != null) {
            tagDTO.setPostUuids(tag.getPosts().stream()
                    .map(Post::getUuid)
                    .collect(Collectors.toSet()));
        }
        return tagDTO;
    }

    public Tag toEntity(TagDTO tagDTO) {
        return toEntity(tagDTO, Tag.class);
    }
}

package banatech.gn.preguie_blogservice.service.postfile;

import banatech.gn.preguie_blogservice.dto.PostFileDTO;
import banatech.gn.preguie_blogservice.model.PostFile;
import banatech.gn.preguie_blogservice.service.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class PostFileMapper extends EntityMapper {

    public PostFileDTO toDto(PostFile postFile) {
        return toDto(postFile, PostFileDTO.class);
    }

    public PostFile toEntity(PostFileDTO postFileDTO) {
        return toEntity(postFileDTO, PostFile.class);
    }
}

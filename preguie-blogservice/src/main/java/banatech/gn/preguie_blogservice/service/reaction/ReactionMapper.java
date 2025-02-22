package banatech.gn.preguie_blogservice.service.reaction;

import banatech.gn.preguie_blogservice.dto.ReactionDTO;
import banatech.gn.preguie_blogservice.model.Reaction;
import banatech.gn.preguie_blogservice.service.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ReactionMapper extends EntityMapper {

    public ReactionDTO toDto(Reaction reaction) {
        ReactionDTO reactionDTO = toDto(reaction, ReactionDTO.class);
        if (reaction.getPost() != null) {
            reactionDTO.setPostUuid(reaction.getPost().getUuid());
        }
        if (reaction.getPostComment() != null) {
            reactionDTO.setPostCommentUuid(reaction.getPostComment().getUuid());
        }
        return reactionDTO;
    }

    public Reaction toEntity(ReactionDTO reactionDTO) {
        return toEntity(reactionDTO, Reaction.class);
    }
}

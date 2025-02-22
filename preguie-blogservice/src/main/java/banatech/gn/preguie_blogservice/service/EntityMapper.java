package banatech.gn.preguie_blogservice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public abstract class EntityMapper {

    protected final ModelMapper modelMapper;

    public EntityMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    // Méthode générique pour mapper une entité vers un DTO
    public <D, E> D toDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    // Méthode générique pour mapper un DTO vers une entité
    public <D, E> E toEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    // Méthode générique pour mapper une liste d'entités vers une liste de DTOs
    public <D, E> List<D> toDtoList(List<E> entities, Class<D> dtoClass) {
        return entities.stream()
                .map(entity -> toDto(entity, dtoClass))
                .collect(Collectors.toList());
    }

    // Méthode générique pour mapper un Set d'entités vers un Set de DTOs
    public <D, E> Set<D> toDtoSet(Set<E> entities, Class<D> dtoClass) {
        return entities.stream()
                .map(entity -> toDto(entity, dtoClass))
                .collect(Collectors.toSet());
    }

    // Méthode pour mettre à jour une entité existante avec les données d'un DTO
    public <D, E> void updateEntityFromDto(D dto, E entity) {
        modelMapper.map(dto, entity);
    }
}

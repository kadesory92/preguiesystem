package banatech.gn.preguie_registerservice.model;

import jakarta.persistence.Entity;

import java.util.Set;
import java.util.UUID;

@Entity
public class TravelHistory extends EntityId {
    private UUID userUuid;
    private Set<TouristVisitDetail> touristVisitDetails;
}

package banatech.gn.preguie_registerservice.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.List;

@Entity
public class TouristVisitDetail extends EntityId {
    private String pays;
    private List<String> cities;
    private LocalDate dateOfEntry;
    private LocalDate releaseDate;
    private int periodOfDay;
}

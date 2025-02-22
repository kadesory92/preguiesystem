package banatech.gn.preguie_registerservice.registre.model;

import banatech.gn.preguie_registerservice.document.model.Document;
import banatech.gn.preguie_registerservice.dto.User;
import banatech.gn.preguie_registerservice.enums.ProfileUser;
import banatech.gn.preguie_registerservice.model.*;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity
public class Profile extends EntityId {
    @OneToOne
    private User user;
    private ProfileUser profileUser;
    @OneToOne
    private GuineanCitizen guineanCitizen;
    @OneToMany
    private Set<TouristVisitDetail> touristVisitDetails;
    private String photoProfile;
    private String city;
    private String address;
    @OneToMany
    private Set<Document> documents;
}

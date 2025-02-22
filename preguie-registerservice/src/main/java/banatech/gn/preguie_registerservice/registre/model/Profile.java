package banatech.gn.preguie_registerservice.model;

import banatech.gn.preguie_registerservice.dto.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Profile extends EntityId{
    @OneToOne
    private User user;
    @OneToOne
    private StudyExpatriate studyExpatriate;
    @OneToOne
    private ProExpatriate proExpatriate;
    @OneToOne
    private TouristExpatriate touristExpatriate;
    private String photoProfile;
    private String city;
    private String address;
}

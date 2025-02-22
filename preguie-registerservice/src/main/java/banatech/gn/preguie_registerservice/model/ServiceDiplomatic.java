package banatech.gn.preguie_registerservice.model;

import banatech.gn.preguie_registerservice.registre.model.DiplomaticStaff;

import java.util.Set;
import java.util.UUID;

public class ServiceDiplomatic {
    private UUID uuid;
    private String name;
    private String description;
    private String country;
    private String city;
    private String address;
    private String email;
    private String phone;
    private Set<DiplomaticStaff> diplomaticStaffs;
}

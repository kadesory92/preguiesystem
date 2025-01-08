package banatech.gn.preguie_authservice.model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String username;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_uuid"),
            inverseJoinColumns = @JoinColumn(name = "role_uuid"))
    private Set<Role> roles;

    public User() {}

    public User(UUID uuid, String username, String email, String password) {
        this.uuid = uuid;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(UUID uuid, String username, String email, String password, Set<Role> roles) {
        this.uuid = uuid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

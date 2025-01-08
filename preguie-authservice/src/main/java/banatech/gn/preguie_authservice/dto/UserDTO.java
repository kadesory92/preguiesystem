package banatech.gn.preguie_authservice.dto;

import java.util.Set;

public class UserDTO {
    private String username;
    private String email;
    private String password;

    private Set<String> roleNames;

    public UserDTO(){}

    public UserDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDTO(String username, String email, String password, Set<String> roleNames) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleNames = roleNames;
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

    public Set<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(Set<String> roleNames) {
        this.roleNames = roleNames;
    }
}

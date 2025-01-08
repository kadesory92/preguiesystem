package banatech.gn.preguie_authservice.response;

import java.util.Set;

public class AuthResponse {
    private final String typeToken = "Bearer";
    private String username;
    private String token;

    private Set<String> roleNames;

    public AuthResponse(){}

    public AuthResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }


    public AuthResponse(String username, String token, Set<String> roleNames) {
        this.username = username;
        this.token = token;
        this.roleNames = roleNames;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(Set<String> roleNames) {
        this.roleNames = roleNames;
    }

    public String getTypeToken() {
        return typeToken;
    }
}

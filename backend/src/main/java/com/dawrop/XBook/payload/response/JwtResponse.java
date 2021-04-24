package com.dawrop.XBook.payload.response;


import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String name;
    private String surname;
    private String email;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String name, String surname, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }
}

package com.dawrop.XBook.payload.response;

import com.dawrop.XBook.models.User;

public class UserWithoutBooksResponse {
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String avatar;

    public UserWithoutBooksResponse(User user) {
        id = user.getId();
        name = user.getName();
        surname = user.getSurname();
        password = user.getPassword()       ;
        email = user.getEmail();
        avatar = user.getAvatar();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

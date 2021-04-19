package com.dawrop.XBook.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String profile_img;
    private int id_rank;

    @ManyToMany
    @JoinTable(
            name = "user_favourite_books",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_book")}
    )
    private Set<Book> favouriteBooks = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<BookRating> ratings = new HashSet<>();



    protected User() {}

    public User(String name, String surname, String password, String email, String profile_img, int id_rank) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.profile_img = profile_img;
        this.id_rank = id_rank;
    }

    public User(String name, String surname, String password, String email) {
        new User(name, surname, password, email, "default.png", 3);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public int getId_rank() {
        return id_rank;
    }

    public void setId_rank(int id_rank) {
        this.id_rank = id_rank;
    }
}

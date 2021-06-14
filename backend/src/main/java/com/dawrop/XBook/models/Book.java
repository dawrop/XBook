package com.dawrop.XBook.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "books",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "title")
        })
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String author;
    @NotBlank
    private String genre;
    @NotBlank
    private String cover;

    @ManyToMany(mappedBy = "userFavouriteBooks")
    private Set<User> userFavouriteBooks;

    protected Book() {}

    public Book(String title, String description, String author, String genre) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Set<User> getUserFavouriteBooks() {
        return userFavouriteBooks;
    }

    public void setUserFavouriteBooks(Set<User> userFavouriteBooks) {
        this.userFavouriteBooks = userFavouriteBooks;
    }
}

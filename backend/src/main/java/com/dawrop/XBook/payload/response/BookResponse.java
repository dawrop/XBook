package com.dawrop.XBook.payload.response;

import com.dawrop.XBook.models.Book;
import com.dawrop.XBook.models.User;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

public class BookResponse {
    private Long id;
    private String title;
    private String description;
    private String author;
    private String genre;
    private String cover;

    private Set<UserWithoutBooksResponse> userFavouriteBooks;

    public BookResponse(Book book) {
        id = book.getId();
        title = book.getTitle();
        description = book.getDescription();
        author = book.getAuthor();
        genre = book.getGenre();
        cover = book.getCover();

        userFavouriteBooks = book.getUserFavouriteBooks().stream().map(UserWithoutBooksResponse::new).collect(Collectors.toSet());
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

    public Set<UserWithoutBooksResponse> getUserFavouriteBooks() {
        return userFavouriteBooks;
    }

    public void setUserFavouriteBooks(Set<UserWithoutBooksResponse> userFavouriteBooks) {
        this.userFavouriteBooks = userFavouriteBooks;
    }
}

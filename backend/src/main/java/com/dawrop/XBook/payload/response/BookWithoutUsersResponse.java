package com.dawrop.XBook.payload.response;

import com.dawrop.XBook.models.Book;

import java.util.Set;
import java.util.stream.Collectors;

public class BookWithoutUsersResponse {
    private Long id;
    private String title;
    private String description;
    private String author;
    private String genre;
    private String cover;

    public BookWithoutUsersResponse(Book book) {
        id = book.getId();
        title = book.getTitle();
        description = book.getDescription();
        author = book.getAuthor();
        genre = book.getGenre();
        cover = book.getCover();

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
}

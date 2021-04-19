package com.dawrop.XBook.models;

import com.dawrop.XBook.models.utils.BookRatingKey;

import javax.persistence.*;

@Entity
public class BookRating {
    @EmbeddedId
    BookRatingKey id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "id_book")
    Book book;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "id_user")
    User user;

    int rating;

    protected BookRating() {}

    public BookRating(BookRatingKey id, Book book, User user, int rating) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.rating = rating;
    }

    public BookRatingKey getId() {
        return id;
    }

    public void setId(BookRatingKey id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

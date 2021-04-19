package com.dawrop.XBook.models.utils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import java.io.Serializable;


@Embeddable
@Table(name = "book_rating")
public class BookRatingKey implements Serializable {
    @Column(name = "id_book")
    Long bookId;

    @Column(name = "id_user")
    Long userId;

    protected BookRatingKey() {}

    public BookRatingKey(Long bookId, Long userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

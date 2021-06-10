package com.dawrop.XBook.repositories;

import com.dawrop.XBook.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleLike(String title);
    List<Book> findByAuthorLike(String author);
    List<Book> findByGenreLike(String genre);
    List<Book> findTop10ByOrderByIdDesc();
}

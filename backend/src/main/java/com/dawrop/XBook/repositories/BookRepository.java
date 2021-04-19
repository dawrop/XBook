package com.dawrop.XBook.repositories;

import com.dawrop.XBook.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findById(long id);
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);
}

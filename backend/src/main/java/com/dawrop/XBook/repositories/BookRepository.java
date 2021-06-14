package com.dawrop.XBook.repositories;

import com.dawrop.XBook.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findTop10ByOrderByIdDesc();
    List<Book> findAllByOrderByIdDesc();
    List<Book> findByUserFavouriteBooks_Id(Long id_user);
}

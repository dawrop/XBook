package com.dawrop.XBook.controllers;

import com.dawrop.XBook.models.Book;
import com.dawrop.XBook.models.ERole;
import com.dawrop.XBook.repositories.BookRepository;
import com.dawrop.XBook.repositories.UserRepository;
import com.dawrop.XBook.security.AccessCheck;
import com.dawrop.XBook.security.jwt.JwtUtils;
import com.dawrop.XBook.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:8081")
@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/books")

    public Object addBook(@Valid @RequestBody Book reqBook) {



        try {
            return bookRepository.save(reqBook);
        }catch (DataAccessException e) {
            return JsonResponse.badRequest("Error");
        }
    }

    @GetMapping("/books")
    public Object getBooks(@RequestParam(required = false) String title,
                           @RequestParam(required = false) String author,
                           @RequestParam(required = false) String genre) {

        if (!AccessCheck.hasRole(ERole.ROLE_ADMIN)) {
            return JsonResponse.unauthorized("error");
        }

        if (title != null)
            return bookRepository.findByTitleLike(title);
        if (author != null)
            return bookRepository.findByAuthorLike(author);
        if (genre != null)
            return bookRepository.findByGenreLike(genre);
        return bookRepository.findTop10ByOrderByIdDesc();
    }

    @GetMapping("/books/{id}")
    public Object getBookByID(@PathVariable Long id) {
        Optional<Book> bookEntity = bookRepository.findById(id);
        if (bookEntity.isPresent())
            return bookEntity.get();
        return JsonResponse.notFound("Nie znaleziono książki o tym ID");
    }

//    @GetMapping("/books")
//    public Object getBooksByTitle(@RequestParam String title) {
//        return bookRepository.findByTitleLike(title);
//    }
//
//    @GetMapping("/books")
//    public Object getBooksByAuthor(@RequestParam String author) {
//        return bookRepository.findByAuthorLike(author);
//    }
//
//    @GetMapping("/books")
//    public Object getBooksByGenre(@RequestParam String genre) {
//        return bookRepository.findByGenreLike(genre);
//    }
}

package com.dawrop.XBook.controllers;

import com.dawrop.XBook.models.Book;
import com.dawrop.XBook.models.User;
import com.dawrop.XBook.repositories.BookRepository;
import com.dawrop.XBook.repositories.UserRepository;
import com.dawrop.XBook.security.services.UserDetailsImpl;
import com.dawrop.XBook.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("http://localhost:8081")
@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/books")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Object addBook(@Valid @RequestBody Book reqBook) {

        try {
            return bookRepository.save(reqBook);
        }catch (DataAccessException e) {
            return JsonResponse.badRequest("Error");
        }
    }

    @GetMapping("/books")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Object getBooks(@RequestParam(required = false) String title,
                           @RequestParam(required = false) String author,
                           @RequestParam(required = false) String genre) {
        if (title != null)
            return bookRepository.findByTitleLike(title);
        if (author != null)
            return bookRepository.findByAuthorLike(author);
        if (genre != null)
            return bookRepository.findByGenreLike(genre);
        return bookRepository.findTop10ByOrderByIdDesc();
    }

    @GetMapping("/books/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Object getBookByID(@PathVariable Long id) {
        Optional<Book> bookEntity = bookRepository.findById(id);
        if (bookEntity.isPresent())
            return bookEntity.get();
        return JsonResponse.notFound("Nie znaleziono książki o tym ID");
    }

    @PostMapping("/favourites")
    public Object addFavouriteBook(@Valid @RequestParam Book reqBook, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Optional<User> user = userRepository.findById(userDetails.getId());
        Optional<Book> newFavouriteBook = bookRepository.findById(reqBook.getId());

        if (newFavouriteBook.isEmpty()) {
            return JsonResponse.badRequest("Book doesn't exist");
        }

        user.get().getUserFavouriteBooks().add(newFavouriteBook.get());
        newFavouriteBook.get().getUserFavouriteBooks().add(user.get());

        return userRepository.save(user.get());
    }

    @GetMapping("/favourites")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public Object getFavouriteBook(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return bookRepository.findByUserFavouriteBooks_Id(userDetails.getId());
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

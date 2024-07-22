package com.books.Books.controllers;

import com.books.Books.dtos.CreateBookDto;
import com.books.Books.dtos.ErrorResponses;
import com.books.Books.entities.Books;
import com.books.Books.services.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @GetMapping("/")
    public Iterable<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id)
    {
        Books book=booksService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/post")
    public ResponseEntity<Books> createBook(@RequestBody CreateBookDto cr)
    {
        Books book = booksService.postBooks(cr);
        return ResponseEntity.ok(book);
    }

    @ExceptionHandler({BooksService.BookNotFound.class})

    public ResponseEntity<String> handleUserException(Exception e)
    {
        String message;
        HttpStatus httpStatus;
        if(e instanceof BooksService.BookNotFound)
        {
            message=e.getMessage();
            httpStatus=HttpStatus.NOT_FOUND;
        }
        else{
            message="Something went wrong";
            httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.ok(message);
    }

}

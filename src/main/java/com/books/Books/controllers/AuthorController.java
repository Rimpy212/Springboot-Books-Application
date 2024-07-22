package com.books.Books.controllers;

import com.books.Books.entities.Author;
import com.books.Books.services.AuthorsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorsService authorsService;

    public AuthorController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/")
    public Iterable<Author> getAuthor()
    {
        return authorsService.getAllAuthors();
    }


    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable("id") Integer id)
    {
        return authorsService.getAuthorById(id);
    }



}

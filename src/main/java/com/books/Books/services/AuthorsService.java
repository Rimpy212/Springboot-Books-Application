package com.books.Books.services;

import com.books.Books.dao.AuthorRepository;
import com.books.Books.entities.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorsService {
    private final AuthorRepository authorRepository;

    public AuthorsService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Iterable<Author> getAllAuthors()
    {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(int id)
    {
        return authorRepository.findById(id);
    }
}

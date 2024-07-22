package com.books.Books.services;

import com.books.Books.dao.BooksRepository;
import com.books.Books.dtos.CreateBookDto;
import com.books.Books.entities.Books;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;
    private final ModelMapper modelMapper;
    public BooksService(BooksRepository booksRepository, ModelMapper modelMapper) {
        this.booksRepository = booksRepository;
        this.modelMapper = modelMapper;
    }

    //returning all the books
    public Iterable<Books> getAllBooks()
    {
        return booksRepository.findAll();
    }

    //getting the books by id
    public Books getBookById(int id)
    {
        Optional<Books> books =booksRepository.findById(id);
        if(books!=null)
        {
            return books.get();
        }
        else{
            throw new BookNotFound(id);
        }
    }

    // Creation of books
    public Books postBooks(CreateBookDto cr)
    {
        var book=modelMapper.map(cr, Books.class);
        return booksRepository.save(book);
    }

    public static class BookNotFound extends NullPointerException{
        public BookNotFound(Integer n)
        {
            super("Book not found with id "+n);
        }
    }

}

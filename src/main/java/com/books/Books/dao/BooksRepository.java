package com.books.Books.dao;


import com.books.Books.entities.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BooksRepository extends CrudRepository<Books, Integer> {

}

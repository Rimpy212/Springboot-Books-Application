package com.books.Books.dtos;


import com.books.Books.entities.Author;
import lombok.Data;

@Data
public class CreateBookDto {
    String title;

    Author author;
}

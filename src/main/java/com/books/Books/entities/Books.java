package com.books.Books.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private int id;

    private String title;

    //one to one mapping of books to author
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
}

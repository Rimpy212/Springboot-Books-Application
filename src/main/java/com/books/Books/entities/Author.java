package com.books.Books.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id")
    private int authorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "language")
    private String language;

    @JsonBackReference
    @OneToOne(mappedBy = "author")            //mapping bidirection
    private Books books;

}

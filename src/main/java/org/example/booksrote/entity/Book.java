package org.example.booksrote.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = "authors")
@Entity
@Table(name = "book")
@Data
public class Book extends BaseEntity{
    private Long isbn;
    private String name;
    private LocalDate publishDate;
    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;
}

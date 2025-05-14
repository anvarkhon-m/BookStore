package org.example.booksrote.dto;

import lombok.Data;
import org.example.booksrote.entity.Book;

import java.time.LocalDate;
import java.util.Set;

@Data
public class AuthorResponse {
    private Long id;
    private String name;
    private Set<BookResponse> books;
}

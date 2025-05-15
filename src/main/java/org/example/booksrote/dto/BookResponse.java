package org.example.booksrote.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class BookResponse {
    private Long id;
    private Long isbn;
    private String name;
    private LocalDate publishDate;
    private Set<AuthorResponse> authors;
    private PublisherResponse publisher;
}

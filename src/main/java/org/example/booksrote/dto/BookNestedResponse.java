package org.example.booksrote.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class BookNestedResponse {
    private Long id;
    private Long isbn;
    private String name;
    private LocalDate publishDate;
}

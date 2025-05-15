package org.example.booksrote.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.booksrote.entity.Author;

import java.time.LocalDate;
import java.util.Set;

@Data
public class BookCreateRequest {
    @NotBlank
    private String name;
    @NotNull
    private LocalDate publishDate;
    private Set<Long> authors;
    private Long publisher;
}

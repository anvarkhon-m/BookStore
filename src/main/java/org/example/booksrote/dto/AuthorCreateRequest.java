package org.example.booksrote.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class AuthorCreateRequest {
    @NotBlank
    private String name;
    private Set<Long> authors;
}

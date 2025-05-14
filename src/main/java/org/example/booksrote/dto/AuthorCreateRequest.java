package org.example.booksrote.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Set;

@Data
public class AuthorCreateRequest {
    @NotBlank
    private String name;
    private AddressCreateRequest address;
    private Set<Long> authors;
}

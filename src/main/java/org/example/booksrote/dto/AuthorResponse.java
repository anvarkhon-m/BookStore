package org.example.booksrote.dto;

import lombok.Data;
import java.util.Set;

@Data
public class AuthorResponse {
    private Long id;
    private String name;
    private AddressResponse address;
    private Set<BookResponse> books;
}

package org.example.booksrote.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PublisherResponse {
    private Long id;
    private String name;
    private String contactEmail;
    private String phoneNumber;
    private String website;
    private Integer establishedYear;
    private AddressResponse address;
    private Set<BookResponse> books;
}

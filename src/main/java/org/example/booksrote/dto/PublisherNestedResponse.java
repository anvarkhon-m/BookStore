package org.example.booksrote.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PublisherNestedResponse {
    private Long id;
    private String name;
    private String contactEmail;
    private String phoneNumber;
    private String website;
    private Integer establishedYear;
}

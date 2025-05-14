package org.example.booksrote.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AddressResponse {
    private Long id;
    private String street;
    private String city;
    private String country;
}

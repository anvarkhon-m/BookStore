package org.example.booksrote.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class AddressCreateRequest {
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
}

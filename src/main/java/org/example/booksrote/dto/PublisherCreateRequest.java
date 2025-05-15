package org.example.booksrote.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PublisherCreateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String contactEmail;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String website;
    @NotNull
    private Integer establishedYear;
    private AddressCreateRequest address;
}

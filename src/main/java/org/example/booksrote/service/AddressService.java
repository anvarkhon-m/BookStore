package org.example.booksrote.service;

import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.AddressCreateRequest;
import org.example.booksrote.dto.AddressResponse;
import org.example.booksrote.dto.AuthorResponse;
import org.example.booksrote.dto.BookResponse;
import org.example.booksrote.entity.Address;
import org.example.booksrote.entity.Author;
import org.example.booksrote.entity.Book;
import org.example.booksrote.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;

    public Address create(AddressCreateRequest request) {
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        return repository.save(address);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AddressResponse get(Long id) {
        return repository.findById(id)
                .map(address -> {
                    AddressResponse response = new AddressResponse();
                    response.setId(address.getId());
                    response.setStreet(address.getStreet());
                    response.setCity(address.getCity());
                    response.setCountry(address.getCountry());
                    return response;
                })
                .orElseThrow(() -> new RuntimeException("Address is not found."));
    }
}

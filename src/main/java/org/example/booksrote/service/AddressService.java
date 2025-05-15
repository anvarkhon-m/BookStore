package org.example.booksrote.service;

import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.AddressResponse;
import org.example.booksrote.mapper.AddressMapper;
import org.example.booksrote.repository.AddressRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;
    private final AddressMapper addressMapper = AddressMapper.getInstance();

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AddressResponse get(Long id) {
        return repository.findById(id)
                .map(address -> {
                    return addressMapper.fromAddress(address);
                })
                .orElseThrow(() -> new RuntimeException("Address is not found."));
    }
}

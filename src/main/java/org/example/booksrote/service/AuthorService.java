package org.example.booksrote.service;

import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.AddressResponse;
import org.example.booksrote.dto.AuthorCreateRequest;
import org.example.booksrote.dto.AuthorResponse;
import org.example.booksrote.dto.BookResponse;
import org.example.booksrote.entity.Author;
import org.example.booksrote.entity.Book;
import org.example.booksrote.mapper.AuthorMapper;
import org.example.booksrote.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public void create(AuthorCreateRequest request) {
        Author author = AuthorMapper.toAuthor(request);
        repository.save(author);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AuthorResponse get(Long id) {
        return repository.findById(id)
                .map(AuthorMapper::getAuthorResponse)
                .orElseThrow(() -> new RuntimeException("Author is not found."));
    }
}

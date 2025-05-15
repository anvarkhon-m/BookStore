package org.example.booksrote.service;

import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.BookCreateRequest;
import org.example.booksrote.dto.BookResponse;
import org.example.booksrote.entity.Book;
import org.example.booksrote.mapper.BookMapper;
import org.example.booksrote.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final BookMapper bookMapper = BookMapper.getInstance();

    public void create(BookCreateRequest request) {
        Book book = bookMapper.toBook(request);

        repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public BookResponse get(Long id) {
        return repository.findById(id)
                .map(book -> {
                    return bookMapper.fromBook(book);
                })
                .orElseThrow(() -> new RuntimeException("Book is not found."));
    }
}

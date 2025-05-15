package org.example.booksrote.service;

import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.BookCreateRequest;
import org.example.booksrote.dto.BookResponse;
import org.example.booksrote.entity.Book;
import org.example.booksrote.mapper.BookMapper;
import org.example.booksrote.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public void create(BookCreateRequest request) {
        Book book = BookMapper.toBook(request);

        repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public BookResponse get(Long id) {
        return repository.findById(id)
                .map(BookMapper::getBookResponse)
                .orElseThrow(() -> new RuntimeException("Book is not found."));
    }
}

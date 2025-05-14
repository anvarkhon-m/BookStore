package org.example.booksrote.service;

import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.AuthorResponse;
import org.example.booksrote.dto.BookCreateRequest;
import org.example.booksrote.dto.BookResponse;
import org.example.booksrote.entity.Author;
import org.example.booksrote.entity.Book;
import org.example.booksrote.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public void create(BookCreateRequest request) {
        Book book = new Book();
        book.setIsbn(request.getIsbn());
        book.setName(request.getName());
        book.setPublishDate(request.getPublishDate());
        Set<Author> authors = new HashSet<>();
        request.getAuthors().forEach(id -> {
            Author author = new Author();
            author.setId(id);
            authors.add(author);
        });
        book.setAuthors(authors);
        repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public BookResponse get(Long id) {
        return repository.findById(id)
                .map(book -> {
                    BookResponse response = new BookResponse();
                    response.setId(book.getId());
                    response.setIsbn(book.getIsbn());
                    response.setName(book.getName());
                    response.setPublishDate(book.getPublishDate());
                    response.setAuthors(book.getAuthors().stream().map(author -> {
                        AuthorResponse authorResponse = new AuthorResponse();
                        authorResponse.setId(author.getId());
                        authorResponse.setName(author.getName());
                        authorResponse.setBooks(null);
                        return authorResponse;
                    }).collect(Collectors.toSet()));
                    return response;
                })
                .orElseThrow(() -> new RuntimeException("Book is not found."));
    }
}

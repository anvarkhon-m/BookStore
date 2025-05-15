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
    private final AddressService addressService;
    private final AuthorMapper authorMapper = AuthorMapper.getInstance();

    public void create(AuthorCreateRequest request) {
        Author author = authorMapper.toAuthor(request);
        repository.save(author);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AuthorResponse get(Long id) {
        return repository.findById(id)
                .map(author -> {
                    AuthorResponse response = new AuthorResponse();
                    response.setId(author.getId());
                    response.setName(author.getName());

                    AddressResponse addressResponse = new AddressResponse();
                    addressResponse.setId(author.getAddress().getId());
                    addressResponse.setStreet(author.getAddress().getStreet());
                    addressResponse.setCity(author.getAddress().getCity());
                    addressResponse.setCountry(author.getAddress().getCountry());

                    response.setAddress(addressResponse);
                    Set<Book> books = author.getBooks();

                    response.setBooks(books.stream().map(book -> {
                        BookResponse bookResponse = new BookResponse();
                        bookResponse.setId(book.getId());
                        bookResponse.setIsbn(book.getIsbn());
                        bookResponse.setName(book.getName());
                        bookResponse.setPublishDate(book.getPublishDate());
                        bookResponse.setAuthors(null);
                        return bookResponse;
                    }).collect(Collectors.toSet()));

                    return response;
                })
                .orElseThrow(() -> new RuntimeException("Author is not found."));
    }
}

package org.example.booksrote.mapper;

import org.example.booksrote.dto.BookCreateRequest;
import org.example.booksrote.dto.BookNestedResponse;
import org.example.booksrote.dto.BookResponse;
import org.example.booksrote.entity.Author;
import org.example.booksrote.entity.Book;
import org.example.booksrote.entity.Publisher;
import org.example.booksrote.util.IsbnGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BookMapper {
    private BookMapper() {}

    public static Book toBook(BookCreateRequest request) {
        Book book = new Book();
        book.setName(request.getName());
        book.setIsbn(IsbnGenerator.generateIsbn());
        book.setPublishDate(request.getPublishDate());

        Set<Author> authors = new HashSet<>();
        request.getAuthors().forEach(id -> {
            Author author = new Author();
            author.setId(id);
            authors.add(author);
        });
        book.setAuthors(authors);

        Publisher publisher = new Publisher();
        publisher.setId(request.getPublisher());

        book.setPublisher(publisher);

        return book;
    }

    public static BookResponse getBookResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setIsbn(book.getIsbn());
        bookResponse.setName(book.getName());
        bookResponse.setPublishDate(book.getPublishDate());

        bookResponse.setAuthors(book.getAuthors().stream().map(AuthorMapper::getAuthorNestedResponse)
                .collect(Collectors.toSet()));

        bookResponse.setPublisher(PublisherMaker.getPublisherNestedResponse(book.getPublisher()));

        return bookResponse;
    }

    public static BookNestedResponse getBookNestedResponse(Book book) {
        BookNestedResponse response = new BookNestedResponse();
        response.setId(book.getId());
        response.setIsbn(book.getIsbn());
        response.setName(book.getName());
        response.setPublishDate(book.getPublishDate());

        return response;
    }
}

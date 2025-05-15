package org.example.booksrote.mapper;

import org.example.booksrote.dto.BookCreateRequest;
import org.example.booksrote.dto.BookResponse;
import org.example.booksrote.entity.Author;
import org.example.booksrote.entity.Book;
import org.example.booksrote.entity.Publisher;
import org.example.booksrote.util.IsbnGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BookMapper {
    private static BookMapper instance;
    private final AuthorMapper authorMapper = AuthorMapper.getInstance();
    private final PublisherMaker publisherMaker = PublisherMaker.getInstance();

    private BookMapper() {}

    public static BookMapper getInstance() {
        if (instance == null) {
            instance = new BookMapper();
        }
        return instance;
    }

    public Book toBook(BookCreateRequest request) {
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

    public BookResponse fromBook(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setIsbn(book.getIsbn());
        bookResponse.setName(book.getName());
        bookResponse.setPublishDate(book.getPublishDate());

        bookResponse.setAuthors(book.getAuthors().stream().map(author -> {
            return authorMapper.fromAuthor(author);
        }).collect(Collectors.toSet()));

        bookResponse.setPublisher(publisherMaker.fromPublisher(book.getPublisher()));

        return bookResponse;
    }
}

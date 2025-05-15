package org.example.booksrote.mapper;

import org.example.booksrote.dto.AuthorCreateRequest;
import org.example.booksrote.dto.AuthorNestedResponse;
import org.example.booksrote.dto.AuthorResponse;
import org.example.booksrote.entity.Author;

import java.util.stream.Collectors;

public class AuthorMapper {
    private AuthorMapper() {}

    public static Author toAuthor(AuthorCreateRequest request) {
        Author author = new Author();
        author.setName(request.getName());
        author.setAddress(AddressMapper.toAddress(request.getAddress()));
        return author;
    }

    public static AuthorResponse getAuthorResponse(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setAddress(AddressMapper.fromAddress(author.getAddress()));
        response.setBooks(author.getBooks().stream().map(BookMapper::getBookNestedResponse)
                .collect(Collectors.toSet()));
        return response;
    }

    public static AuthorNestedResponse getAuthorNestedResponse(Author author) {
        AuthorNestedResponse response = new AuthorNestedResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        return response;
    }

}

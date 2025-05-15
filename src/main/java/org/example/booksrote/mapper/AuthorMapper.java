package org.example.booksrote.mapper;

import org.example.booksrote.dto.AuthorCreateRequest;
import org.example.booksrote.dto.AuthorResponse;
import org.example.booksrote.entity.Author;

public class AuthorMapper {
    private static AuthorMapper instance;
    private final AddressMapper addressMapper = AddressMapper.getInstance();

    private AuthorMapper() {}

    public static AuthorMapper getInstance() {
        if (instance == null) {
            instance = new AuthorMapper();
        }
        return instance;
    }

    public Author toAuthor(AuthorCreateRequest request) {
        Author author = new Author();
        author.setName(request.getName());
        author.setAddress(addressMapper.toAddress(request.getAddress()));
        return author;
    }

    public AuthorResponse fromAuthor(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setAddress(addressMapper.fromAddress(author.getAddress()));
        return response;
    }

}

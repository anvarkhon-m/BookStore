package org.example.booksrote.mapper;

import org.example.booksrote.dto.PublisherCreateRequest;
import org.example.booksrote.dto.PublisherNestedResponse;
import org.example.booksrote.dto.PublisherResponse;
import org.example.booksrote.entity.Publisher;

import java.util.stream.Collectors;

public class PublisherMaker {
    private PublisherMaker() {}


    public static PublisherResponse getPublisherResponse(Publisher publisher) {
        PublisherResponse response = new PublisherResponse();
        response.setId(publisher.getId());
        response.setName(publisher.getName());
        response.setContactEmail(publisher.getContactEmail());
        response.setPhoneNumber(publisher.getPhoneNumber());
        response.setWebsite(publisher.getWebsite());
        response.setEstablishedYear(publisher.getEstablishedYear());
        response.setAddress(AddressMapper.fromAddress(publisher.getAddress()));

        response.setBooks(publisher.getBooks().stream().map(BookMapper::getBookNestedResponse)
                .collect(Collectors.toSet()));
        return response;
    }

    public static PublisherNestedResponse getPublisherNestedResponse(Publisher publisher) {
        PublisherNestedResponse response = new PublisherNestedResponse();
        response.setId(publisher.getId());
        response.setName(publisher.getName());
        response.setContactEmail(publisher.getContactEmail());
        response.setPhoneNumber(publisher.getPhoneNumber());
        response.setWebsite(publisher.getWebsite());
        response.setEstablishedYear(publisher.getEstablishedYear());

        return response;
    }

    public static Publisher toPublisher(PublisherCreateRequest request) {
        Publisher publisher = new Publisher();
        publisher.setName(request.getName());
        publisher.setContactEmail(request.getContactEmail());
        publisher.setPhoneNumber(request.getPhoneNumber());
        publisher.setWebsite(request.getWebsite());
        publisher.setEstablishedYear(request.getEstablishedYear());
        publisher.setAddress(AddressMapper.toAddress(request.getAddress()));
        publisher.setBooks(null);
        return publisher;
    }
}

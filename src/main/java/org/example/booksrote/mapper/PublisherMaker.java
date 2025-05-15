package org.example.booksrote.mapper;

import org.example.booksrote.dto.PublisherCreateRequest;
import org.example.booksrote.dto.PublisherResponse;
import org.example.booksrote.entity.Publisher;

public class PublisherMaker {
    private static PublisherMaker instance;
    private final AddressMapper addressMapper = AddressMapper.getInstance();

    private PublisherMaker() {}

    public static PublisherMaker getInstance() {
        if(instance == null) {
            instance = new PublisherMaker();
        }
        return instance;
    }

    public PublisherResponse fromPublisher(Publisher publisher) {
        PublisherResponse publisherResponse = new PublisherResponse();
        publisherResponse.setId(publisher.getId());
        publisherResponse.setName(publisher.getName());
        publisherResponse.setContactEmail(publisher.getContactEmail());
        publisherResponse.setPhoneNumber(publisher.getPhoneNumber());
        publisherResponse.setWebsite(publisher.getWebsite());
        publisherResponse.setEstablishedYear(publisher.getEstablishedYear());
        publisherResponse.setAddress(addressMapper.fromAddress(publisher.getAddress()));
        publisherResponse.setBooks(null);

        return publisherResponse;
    }

    public Publisher toPublisher(PublisherCreateRequest request) {
        Publisher publisher = new Publisher();
        publisher.setName(request.getName());
        publisher.setContactEmail(request.getContactEmail());
        publisher.setPhoneNumber(request.getPhoneNumber());
        publisher.setWebsite(request.getWebsite());
        publisher.setEstablishedYear(request.getEstablishedYear());
        publisher.setAddress(addressMapper.toAddress(request.getAddress()));
        return publisher;
    }
}

package org.example.booksrote.service;

import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.*;
import org.example.booksrote.entity.Publisher;
import org.example.booksrote.mapper.PublisherMaker;
import org.example.booksrote.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository repository;
    private final PublisherMaker publisherMaker = PublisherMaker.getInstance();

    public void create(PublisherCreateRequest request) {
        Publisher publisher = publisherMaker.toPublisher(request);
        repository.save(publisher);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public PublisherResponse get(Long id) {
        return repository.findById(id)
                .map(publisher -> {
                    return publisherMaker.fromPublisher(publisher);
                })
                .orElseThrow(() -> new RuntimeException("Publisher is not found."));
    }
}

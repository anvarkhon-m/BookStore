package org.example.booksrote.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.PublisherCreateRequest;
import org.example.booksrote.dto.PublisherResponse;
import org.example.booksrote.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PublisherCreateRequest request) {
        service.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisher(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

package org.example.booksrote.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.AuthorCreateRequest;
import org.example.booksrote.dto.AuthorResponse;
import org.example.booksrote.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid AuthorCreateRequest request) {
        service.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

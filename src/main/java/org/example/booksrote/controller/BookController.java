package org.example.booksrote.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.booksrote.dto.BookCreateRequest;
import org.example.booksrote.dto.BookResponse;
import org.example.booksrote.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid BookCreateRequest request) {
        service.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

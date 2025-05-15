package org.example.booksrote.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = "books")
@Entity
@Table(name = "publisher")
@Data
public class Publisher extends BaseEntity{
    private String name;
    private String contactEmail;
    private String phoneNumber;
    private String website;
    private Integer establishedYear;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<Book> books;
}

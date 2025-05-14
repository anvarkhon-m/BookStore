package org.example.booksrote.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = "books")
@Entity
@Table(name = "author")
@Data
public class Author extends BaseEntity{
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}

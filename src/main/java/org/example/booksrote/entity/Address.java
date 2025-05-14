package org.example.booksrote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address extends BaseEntity{
    private String street;
    private String city;
    private String country;
}

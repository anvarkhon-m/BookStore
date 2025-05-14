package org.example.booksrote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "address")
@Data
public class Address extends BaseEntity{
    private String street;
    private String city;
    private String country;
}

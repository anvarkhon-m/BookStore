package org.example.booksrote.repository;

import org.example.booksrote.entity.Address;
import org.example.booksrote.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}

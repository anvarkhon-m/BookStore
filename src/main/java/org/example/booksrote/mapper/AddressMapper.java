package org.example.booksrote.mapper;

import org.example.booksrote.dto.AddressCreateRequest;
import org.example.booksrote.dto.AddressResponse;
import org.example.booksrote.entity.Address;

public class AddressMapper {
    private static AddressMapper instance;

    private AddressMapper() {}

    public static AddressMapper getInstance() {
        if (instance == null) {
            instance = new AddressMapper();
        }
        return instance;
    }

    public AddressResponse fromAddress(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setCity(address.getCity());
        addressResponse.setCountry(address.getCountry());
        return addressResponse;
    }

    public Address toAddress(AddressCreateRequest request) {
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        return address;
    }
}

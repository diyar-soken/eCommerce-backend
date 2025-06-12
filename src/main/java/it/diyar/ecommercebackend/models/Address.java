package it.diyar.ecommercebackend.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String address;
    private int house_number;
    private String zipCode;
    private String city;
    private String state;
    private String country;
}

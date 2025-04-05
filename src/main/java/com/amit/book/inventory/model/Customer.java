package com.amit.book.inventory.model;

import lombok.Data;

@Data
public class Customer {

    private int customerID;
    private String customerName;
    private String customerAddress;
    private Long customerContact;
    private String customerEmailID;

    public Customer(int id, String name, String address, Long contact, String emailID) {
        this.customerID = id;
        this.customerName = name;
        this.customerAddress = address;
        this.customerContact = contact;
        this.customerEmailID = emailID;
    }
}

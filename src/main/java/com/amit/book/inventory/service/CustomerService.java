package com.amit.book.inventory.service;

import com.amit.book.inventory.exception.InvalidBookIDException;
import com.amit.book.inventory.exception.InvalidBookNameException;
import com.amit.book.inventory.exception.InvalidBookPriceException;
import com.amit.book.inventory.model.Book;
import com.amit.book.inventory.model.Customer;
import com.amit.book.inventory.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerService implements CustomerServiceInterface {

    public String getCustomerDetails(Customer customer) {
        return "<h2>Customer Details Submitted:</h2>" +
                "<ul>" +
                "<li>ID: " + customer.getCustomerID() + "</li>" +
                "<li>Name: " + customer.getCustomerName() + "</li>" +
                "<li>Address: " + customer.getCustomerAddress() + "</li>" +
                "<li>Contact: " + customer.getCustomerContact() + "</li>" +
                "<li>EmailID: " + customer.getCustomerEmailID() + "</li>" +
                "</ul>";
    }

    @Override
    public void acceptCustomerInfo() throws SQLException {

    }

    @Override
    public void displayCustomerInfo() throws SQLException {

    }
}
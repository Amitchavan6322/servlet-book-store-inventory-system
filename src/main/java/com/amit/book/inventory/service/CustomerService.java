package com.amit.book.inventory.service;

import com.amit.book.inventory.model.Customer;
import com.amit.book.inventory.repository.CustomerRepository;

import java.sql.SQLException;

public class CustomerService implements CustomerServiceInterface {

    private static final CustomerRepository customerRepository = new CustomerRepository();
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
    public boolean acceptCustomerInfo(Customer customer) throws SQLException {
        if (customerRepository.fillCustomerInfo(customer)) {
            System.out.println("customer inserted successfully!");
        } else {
            System.out.println("Failed to insert customer.");
            return false;
        }
        return true;
    }

    @Override
    public void displayCustomerInfo() throws SQLException {

    }
}
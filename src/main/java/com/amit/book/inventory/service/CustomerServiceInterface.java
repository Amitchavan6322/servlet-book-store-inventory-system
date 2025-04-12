package com.amit.book.inventory.service;

import com.amit.book.inventory.model.Customer;

import java.sql.SQLException;

public interface CustomerServiceInterface {
    boolean acceptCustomerInfo(Customer customer) throws SQLException;
    void displayCustomerInfo() throws SQLException;

}

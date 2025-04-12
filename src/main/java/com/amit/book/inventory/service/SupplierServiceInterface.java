package com.amit.book.inventory.service;

import com.amit.book.inventory.model.Supplier;

import java.sql.SQLException;

public interface SupplierServiceInterface {

    boolean acceptSupplierInfo(Supplier supplier) throws SQLException;
    void displaySupplierInfo() throws SQLException;
}

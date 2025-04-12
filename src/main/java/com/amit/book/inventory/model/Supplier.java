package com.amit.book.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    private int supplierID;
    private String supplierName;
    private String supplierAddress;
    private Long supplierContact;
    private String supplierEmailId;

}

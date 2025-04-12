package com.amit.book.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int bookId;
    private String name;
    private String author;
    private String publisher;
    private int noOfCopies;
    private BookCategory category; // Use BookCategory enum instead of String
    private String storeLocation;
    private int price;

    // Constructor
    public Book(int id, String name, String author, String publisher,
                int copies, String category, String location, double price) {
        this.bookId = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.noOfCopies = copies;
        this.category = BookCategory.valueOf(category);
        this.storeLocation = location;
        this.price = (int) price;
    }

}

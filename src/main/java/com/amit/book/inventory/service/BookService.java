package com.amit.book.inventory.service;

import com.amit.book.inventory.model.Book;

public class BookService {
    public String getBookDetails(Book book) {
        return "<h2>Book Details Submitted:</h2>" +
                "<ul>" +
                "<li>ID: " + book.getBookId() + "</li>" +
                "<li>Name: " + book.getName() + "</li>" +
                "<li>Author: " + book.getAuthor() + "</li>" +
                "<li>Publisher: " + book.getPublisher() + "</li>" +
                "<li>Copies: " + book.getNoOfCopies() + "</li>" +
                "<li>Category: " + book.getCategory() + "</li>" +
                "<li>Location: " + book.getStoreLocation() + "</li>" +
                "<li>Price: $" + book.getPrice() + "</li>" +
                "</ul>";
    }
}

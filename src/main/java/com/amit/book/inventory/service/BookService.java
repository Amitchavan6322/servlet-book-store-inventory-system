package com.amit.book.inventory.service;

import com.amit.book.inventory.model.Book;
import com.amit.book.inventory.repository.BookRepository;

import java.sql.SQLException;

public class BookService {

    private static final BookRepository bookRepository = new BookRepository();

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

    public boolean bookInserted(Book book) throws SQLException {
        if (bookRepository.fillTheBookInfo(book)) {
            System.out.println("Book inserted successfully!");
        } else {
            System.out.println("Failed to insert book.");
            return false;
        }
        return true;
    }
}

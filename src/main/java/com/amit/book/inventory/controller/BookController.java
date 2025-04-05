package com.amit.book.inventory.controller;

import com.amit.book.inventory.model.Book;
import com.amit.book.inventory.service.BookService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BookController extends HttpServlet {

    BookService bookService = new BookService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("@@@@@@@@ inside the BookController doGet() method");

        int id = Integer.parseInt(request.getParameter("bookid"));
        String name = request.getParameter("bookname");
        String author = request.getParameter("bookauthor");
        String publisher = request.getParameter("bookpublisher");
        int copies = Integer.parseInt(request.getParameter("bookcopies"));
        String category = request.getParameter("bookcategory");
        String location = request.getParameter("booklocation");
        double price = Double.parseDouble(request.getParameter("bookprice"));

        Book book = new Book(id, name, author, publisher, copies, category, location, price);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println(bookService.getBookDetails(book));
        writer.println("</body></html>");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("@@@@@@@@ inside the BookController service() method");
        this.doGet(request, response);
    }
}
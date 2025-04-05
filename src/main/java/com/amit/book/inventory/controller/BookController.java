package com.amit.book.inventory.controller;

import com.amit.book.inventory.model.Book;
import com.amit.book.inventory.model.BookCategory;
import com.amit.book.inventory.service.BookService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

    public void doPost (HttpServletRequest request, HttpServletResponse response) {
        System.out.println("@@@@@@@@ inside the BookController doPost() method");

        int id = Integer.parseInt(request.getParameter("bookid"));
        String name = request.getParameter("bookname");
        String author = request.getParameter("bookauthor");
        String publisher = request.getParameter("bookpublisher");
        int copies = Integer.parseInt(request.getParameter("bookcopies"));
        String category = request.getParameter("bookcategory");
        String location = request.getParameter("booklocation");
        double price = Double.parseDouble(request.getParameter("bookprice"));

        Book book = new Book();
        book.setBookId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setNoOfCopies(copies);
        book.setCategory(BookCategory.valueOf(category));
        book.setStoreLocation(location);
        book.setPrice((int) price);

        try {
            boolean isInserted = bookService.bookInserted(book);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> book object inserted to db</h1>");
            } else {
                out.println("<h1> book object is NOT inserted to db</h1>");
            }
            out.println("</body></html>");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("@@@@@@@@ inside the BookController service() method");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }
}
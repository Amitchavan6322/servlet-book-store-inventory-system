package com.amit.book.inventory.controller;

import com.amit.book.inventory.model.Customer;
import com.amit.book.inventory.service.CustomerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class CustomerController extends HttpServlet {

    CustomerService customerService = new CustomerService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("@@@@@@@@ inside the CustomerController doGet() method");
            int id = Integer.parseInt(request.getParameter("customerid"));
            String name = request.getParameter("customername");
            String address = request.getParameter("customeraddress");
            Long contact = Long.valueOf(request.getParameter("customercontact"));
            String emailID = request.getParameter("customeremailid");

            Customer customer = new Customer(id, name, address, contact, emailID);
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html><body>");
            writer.println(customerService.getCustomerDetails(customer));
            writer.println("</body></html>");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("@@@@@@@@ inside the BookController service() method");
        this.doGet(request, response);
    }
}
package com.amit.book.inventory.controller;

import com.amit.book.inventory.model.Customer;
import com.amit.book.inventory.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

    public void doPost (HttpServletRequest request, HttpServletResponse response) {
        System.out.println("@@@@@@@@ inside the CustomerController doPost() method");

        int id = Integer.parseInt(request.getParameter("customerid"));
        String name = request.getParameter("customername");
        String address = request.getParameter("customeraddress");
        Long contact = Long.valueOf(request.getParameter("customercontact"));
        String emailID = request.getParameter("customeremailid");

        Customer customer = new Customer();
        customer.setCustomerID(id);
        customer.setCustomerName(name);
        customer.setCustomerAddress(address);
        customer.setCustomerContact(contact);
        customer.setCustomerEmailID(emailID);

        try {
            boolean isInserted = customerService.acceptCustomerInfo(customer);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> customer object inserted to db</h1>");
            } else {
                out.println("<h1> customer object is NOT inserted to db</h1>");
            }
            out.println("</body></html>");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("@@@@@@@@ inside the CustomerController service() method");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }
}
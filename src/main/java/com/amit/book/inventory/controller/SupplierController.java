package com.amit.book.inventory.controller;

import com.amit.book.inventory.model.Supplier;
import com.amit.book.inventory.service.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class SupplierController extends HttpServlet {

    SupplierService supplierService = new SupplierService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("@@@@@@@@ inside the SupplierController doGet() method");
        int id = Integer.parseInt(request.getParameter("supplierid"));
        String name = request.getParameter("suppliername");
        String address = request.getParameter("supplieraddress");
        Long contact = Long.valueOf(request.getParameter("suppliercontact"));
        String emailID = request.getParameter("supplieremailid");

        Supplier supplier = new Supplier(id, name, address, contact, emailID);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println(supplierService.getSupplierDetails(supplier));
        writer.println("</body></html>");
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) {
        System.out.println("@@@@@@@@ inside the CustomerController doPost() method");

        int id = Integer.parseInt(request.getParameter("supplierid"));
        String name = request.getParameter("suppliername");
        String address = request.getParameter("supplieraddress");
        Long contact = Long.valueOf(request.getParameter("suppliercontact"));
        String emailID = request.getParameter("supplieremailid");

        Supplier supplier = new Supplier();
        supplier.setSupplierID(id);
        supplier.setSupplierName(name);
        supplier.setSupplierAddress(address);
        supplier.setSupplierContact(contact);
        supplier.setSupplierEmailId(emailID);

        try {
            boolean isInserted = supplierService.acceptSupplierInfo(supplier);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (isInserted) {
                out.println("<h1> supplier object inserted to db</h1>");
            } else {
                out.println("<h1> supplier object is NOT inserted to db</h1>");
            }
            out.println("</body></html>");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("@@@@@@@@ inside the SupplierController service() method");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }
}

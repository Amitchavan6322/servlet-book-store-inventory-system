package com.amit.book.inventory.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

/*    public Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/stepupdb";
            String username = "root";
            String password = "admin";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }*/

    private static final String URL = "jdbc:mysql://localhost:3306/stepupdb"; // <-- change to your DB name
    private static final String USER = "root"; // <-- use your DB user
    private static final String PASSWORD = "admin"; // <-- use your DB password

    public Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connection established: " + connection);
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver not found: " + e.getMessage());
            throw new SQLException("JDBC Driver not found", e);
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to DB: " + e.getMessage());
            throw e;
        }
    }
}
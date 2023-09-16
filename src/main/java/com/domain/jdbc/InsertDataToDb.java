package com.domain.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataToDb {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "your_username";
        String password = "your_password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load the JDBC driver (MySQL driver in this example)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection(dbUrl, username, password);

            // Define the SQL INSERT query with placeholders
            String insertQuery = "INSERT INTO mytable (name, age) VALUES (?, ?)";

            // Create a PreparedStatement with the SQL query
            preparedStatement = connection.prepareStatement(insertQuery);

            // Set values for the placeholders
            preparedStatement.setString(1, "John Doe");
            preparedStatement.setInt(2, 30);

            // Execute the INSERT query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insertion successful.");
            } else {
                System.out.println("Insertion failed.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in a try-catch block
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

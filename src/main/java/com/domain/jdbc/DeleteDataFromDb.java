package com.domain.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataFromDb {

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

            // Define the SQL DELETE query with a WHERE clause to specify which records to delete
            String deleteQuery = "DELETE FROM mytable WHERE id = ?"; // Adjust the query and table name

            // Create a PreparedStatement with the SQL query
            preparedStatement = connection.prepareStatement(deleteQuery);

            // Set the value for the placeholder in the WHERE clause (e.g., the record with id 1)
            preparedStatement.setInt(1, 1); // Replace with the actual value or variable

            // Execute the DELETE query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Deletion successful.");
            } else {
                System.out.println("No records were deleted.");
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

package org.example.jdbc;

import java.sql.*;

public class CreatePreparedStatements {

    public static void main(String[] args) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
        String user = "root";
        String password = "shiva@2002#24";

        try {
            myConn = DriverManager.getConnection(url, user, password);
            myStmt = myConn.prepareStatement("SELECT * FROM Persons WHERE LastName = ?");
            myStmt.setString(1, "Singh");
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                // Retrieve and print data from the result set
                int id = myRs.getInt("PersonID");
                String lastName = myRs.getString("LastName");
                String firstName = myRs.getString("FirstName");
                System.out.println("Person ID: " + id + ", Last Name: " + lastName + ", First Name: " + firstName);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (myRs != null) myRs.close();
                if (myStmt != null) myStmt.close();
                if (myConn != null) myConn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}

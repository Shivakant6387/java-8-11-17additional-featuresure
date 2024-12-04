package org.example.jdbc;

import java.sql.*;

public class InsertDataUsingJdbc {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
        String user = "root";
        String password = "shiva@2002#24";
        try {
            //Get a connection to database
            connection = DriverManager.getConnection(url, user, password);
            //Create a statement
            statement = connection.createStatement();
            //Insert a new Persons
            System.out.println("Inserting a new Persons to database\n");
            int rowAffected = statement.executeUpdate("insert into Persons" +
                    "(PersonID,LastName,FirstName,Address,City) "
                    + "values" +
                    "(2,'Mishra','Sakshi','mahoba','mahoba')");
            resultSet = statement.executeQuery("select * from Persons order by PersonID");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("LastName") + "," + resultSet.getString("FirstName"));
            }

        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e.getLocalizedMessage());
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
}

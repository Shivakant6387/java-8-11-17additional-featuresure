package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDeleteExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
        String user = "root";
        String password = "data#12345";
        try {
            connection= DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            System.out.println("BEFORE THE DELETE");
            resultSet=statement.executeQuery("select * from Persons ");
            while (resultSet.next()){
                System.out.println(resultSet.getString("LastName")+", "+resultSet.getString("FirstName"));
            }
            System.out.println("\nDELETING THE PERSON: Mishra\n");
            int deleteData=statement.executeUpdate("delete from Persons "+"where LastName='Mishra' and FirstName='Sakshi'");

            System.out.println("AFTER THE DELETE....");
            resultSet=statement.executeQuery("select * from Persons ");
            while (resultSet.next()){
                System.out.println(resultSet.getString("LastName")+", "+resultSet.getString("FirstName"));
            }
        }catch (Exception e){
            e.getLocalizedMessage();
            System.out.println(e.getLocalizedMessage());
        }
    }
}

package MySql;


/*
 * Program: CreateTable
 * Description:
 * This program establishes a connection between Java and MySQL
 * using JDBC (Java Database Connectivity).
 *
 * It connects to the AddressBookService database and creates
 * a table named AddressBooks with columns to store contact
 * information such as First Name, Last Name, Address, City,
 * State, Zip Code, Phone Number and Email.
 *
 * JDBC is used to execute the SQL CREATE TABLE statement
 * from the Java application.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "Vishruth45";

        // SQL query to create the AddressBooks table
        String query = "create table AddressBooks(" +
                "First varchar(20), " +
                "LastName varchar(20)," +
                "Address varchar(30)," +
                "City varchar(20)," +
                "State varchar(30)," +
                "ZipCode int," +
                "PhoneNumber int," +
                "Email varchar(20))";

        try {

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the MySQL database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Create a Statement object to execute SQL queries
            Statement st = con.createStatement();

            // Execute the CREATE TABLE query
            int count = st.executeUpdate(query);

        } catch (Exception e) {

            // Handle exceptions that occur during database operations
            throw new RuntimeException(e);
        }
    }
}





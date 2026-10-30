
        /*
         * Program: InsertData
         * Description:
         * This program establishes a connection between Java and MySQL
         * using JDBC (Java Database Connectivity).
         *
         * It connects to the AddressBookService database and inserts
         * multiple contact records into the AddressBooks table.
         *
         * The INSERT INTO SQL statement is used to insert details such
         * as First Name, Last Name, Address, City, State, Zip Code,
         * Phone Number and Email.
         *
         * JDBC Statement is used to execute the SQL INSERT query
         * from the Java application.
         */

        package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {

    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "Vishruth45";

        // SQL query to insert multiple records into the AddressBooks table
        String query = "insert into AddressBooks\n" +
                "VALUES\n" +
                "(\"Pokuru\",\"Akhil Durgesh\",\"Kadapa, Andhra Pradesh\",\"Kadapa\",\"Andhra Pradesh\",603203,79933,\"akhil@gmail.com\"),\n" +
                "(\"Kokatam\",\"charan\",\"Kadapa, Andhra Pradesh\",\"Kadapa\",\"Andhra Pradesh\",603203,70133,\"charan@gmail.com\"),\n" +
                "(\"kantla\",\"Avinash\",\"Hyderbad, Telengana\",\"Hyderbad\",\"Telengana\",524232,32895,\"avinash@gmail.com\");";

        try {

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the MySQL database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Create a Statement object to execute SQL queries
            Statement st = con.createStatement();

            // Execute the INSERT query and get the number of affected rows
            int count = st.executeUpdate(query);

        } catch (Exception e) {

            // Handle exceptions that occur during database operations
            throw new RuntimeException(e);
        }
    }
}

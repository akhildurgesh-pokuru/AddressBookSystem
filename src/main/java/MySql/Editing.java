package MySql;

/*
 * Program to update the phone number of a contact in the AddressBooks table using JDBC.
 * It updates the record based on the LastName provided in the SQL UPDATE statement.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Editing {

    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "Vishruth45";

        // SQL query to update the phone number of a specific contact
        String query = "update AddressBooks set PhoneNumber = 7893060 where LastName = \"Akhil Durgesh\"";

        try {

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the MySQL database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Create a Statement object to execute SQL queries
            Statement st = con.createStatement();

            // Execute the UPDATE query and get the number of affected rows
            int count = st.executeUpdate(query);

        } catch (Exception e) {

            // Handle exceptions that occur during database operations
            throw new RuntimeException(e);
        }
    }
}



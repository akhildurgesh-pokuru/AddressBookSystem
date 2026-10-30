
/*
 * Program to delete a person from the AddressBooks table using the person's name.
 * It connects to MySQL using JDBC and executes a DELETE statement.
 */

package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeletePerson {
    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "vishruth";

        // SQL query to delete a person using their name
        String query = "DELETE FROM AddressBooks WHERE LastName = ?";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Prepare the SQL statement
            PreparedStatement st = con.prepareStatement(query);

            // Set the person's name
            st.setString(1, "Akhil Durgesh");

            // Execute the DELETE query
            int count = st.executeUpdate();

            System.out.println("Records deleted: " + count);

            st.close();
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


/*
 * Program to identify an Address Book using its name and type.
 * It updates the AddressBookName and Type columns for a particular contact.
 */

package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateAddressBookDetails {
    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "vishruth";

        // SQL query to update Address Book name and type
        String query = "UPDATE AddressBooks SET AddressBookName = ?, `Type` = ? WHERE LastName = ?";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Prepare the SQL statement
            PreparedStatement st = con.prepareStatement(query);

            // Set Address Book name, type and person's name
            st.setString(1, "Personal Address Book");
            st.setString(2, "Friends");
            st.setString(3, "Akhil Durgesh");

            // Execute the UPDATE query
            int count = st.executeUpdate();

            System.out.println("Records updated: " + count);

            st.close();
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

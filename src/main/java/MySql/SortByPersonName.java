
/*
 * Program to retrieve contacts alphabetically by person's name for a given city.
 * It connects to MySQL using JDBC and executes a SELECT query with ORDER BY.
 */

package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SortByPersonName {
    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "Vishruth45";

        // SQL query to retrieve and sort persons by name
        String query = "SELECT * FROM AddressBooks WHERE City = ? ORDER BY LastName ASC";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Prepare the SQL statement
            PreparedStatement st = con.prepareStatement(query);

            // Set the city name
            st.setString(1, "Kadapa");

            // Execute the SELECT query
            ResultSet rs = st.executeQuery();

            // Display contacts in alphabetical order
            while (rs.next()) {
                System.out.println(
                        rs.getString("LastName") + " - " +
                                rs.getString("City") + " - " +
                                rs.getString("PhoneNumber")
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

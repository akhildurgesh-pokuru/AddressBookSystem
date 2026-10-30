
/*
 * Program to find the size of the Address Book based on city and state.
 * It connects to MySQL using JDBC and counts contacts using GROUP BY.
 */

package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountByCityState {
    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "vishruth";

        // SQL query to count persons grouped by city and state
        String query = "SELECT City, State, COUNT(*) AS Total " +
                "FROM AddressBooks GROUP BY City, State";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Create a Statement object
            Statement st = con.createStatement();

            // Execute the SELECT query
            ResultSet rs = st.executeQuery(query);

            // Display the count of persons in each city and state
            while (rs.next()) {
                System.out.println(
                        "City: " + rs.getString("City") +
                                ", State: " + rs.getString("State") +
                                ", Total Persons: " + rs.getInt("Total")
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

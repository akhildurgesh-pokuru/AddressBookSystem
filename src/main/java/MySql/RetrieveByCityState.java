
/*
 * Program to retrieve persons belonging to a particular city or state.
 * It connects to MySQL using JDBC and executes a SELECT statement.
 */

package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveByCityState {
    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "vishruth";

        // SQL query to retrieve persons by city or state
        String query = "SELECT * FROM AddressBooks WHERE City = ? OR State = ?";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Prepare the SQL statement
            PreparedStatement st = con.prepareStatement(query);

            // Set the city and state values
            st.setString(1, "Kadapa");
            st.setString(2, "Andhra Pradesh");

            // Execute the SELECT query
            ResultSet rs = st.executeQuery();

            // Display the retrieved records
            while (rs.next()) {
                System.out.println(
                        rs.getString("First") + " " +
                                rs.getString("LastName") + " " +
                                rs.getString("City") + " " +
                                rs.getString("State") + " " +
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

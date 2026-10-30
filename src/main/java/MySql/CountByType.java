
/*
 * Program to count the number of contacts based on their Address Book type.
 * It connects to MySQL using JDBC and groups contacts using GROUP BY.
 */

package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountByType {
    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "vishruth";

        // SQL query to count contacts based on type
        String query = "SELECT `Type`, COUNT(*) AS Total " +
                "FROM AddressBooks GROUP BY `Type`";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Create a Statement object
            Statement st = con.createStatement();

            // Execute the SELECT query
            ResultSet rs = st.executeQuery(query);

            // Display the number of contacts in each type
            while (rs.next()) {
                System.out.println(
                        "Type: " + rs.getString("Type") +
                                ", Total Contacts: " + rs.getInt("Total")
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


/*
 * Program to add the same person to both Friends and Family Address Books.
 * It connects to MySQL using JDBC and inserts two records with different types.
 */

package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddToFriendAndFamily {
    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "vishruth";

        // SQL query to insert a person into the Address Book
        String query = "INSERT INTO AddressBooks " +
                "(First, LastName, Address, City, State, ZipCode, PhoneNumber, Email, AddressBookName, `Type`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            Connection con = DriverManager.getConnection(url, username, pass);

            // Prepare the SQL statement
            PreparedStatement st = con.prepareStatement(query);

            // Insert the person as a Friend
            st.setString(1, "Kokatam");
            st.setString(2, "Charan");
            st.setString(3, "Kadapa, Andhra Pradesh");
            st.setString(4, "Kadapa");
            st.setString(5, "Andhra Pradesh");
            st.setInt(6, 603203);
            st.setInt(7, 70133);
            st.setString(8, "charan@gmail.com");
            st.setString(9, "Personal Address Book");
            st.setString(10, "Friends");

            int friendCount = st.executeUpdate();

            // Insert the same person as a Family member
            st.setString(10, "Family");

            int familyCount = st.executeUpdate();

            // Display the insertion results
            System.out.println("Friend records inserted: " + friendCount);
            System.out.println("Family records inserted: " + familyCount);

            st.close();
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

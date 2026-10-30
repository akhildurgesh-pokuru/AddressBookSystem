package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreatingDatabase {
    public static void main(String[] args) throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/AddressBookService";
        String username = "root";
        String pass = "Vishruth45";

        String query = "create database IF NOT EXISTS AddressBookService";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, pass);

            Statement st = con.createStatement();

            int count = st.executeUpdate(query);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}




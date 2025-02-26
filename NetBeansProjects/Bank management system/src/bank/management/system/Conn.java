package bank.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection (Ensure DB name, user, and password are correct)
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "VR$31ecy8h");

            // Step 3: Create a statement
            s = c.createStatement();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }
}

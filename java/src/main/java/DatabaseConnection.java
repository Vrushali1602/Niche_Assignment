import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12740857";
    private static final String USER = "sql12740857"; // Replace with your username
    private static final String PASSWORD = "wD4pMZvwTF"; // Replace with your password

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver."); // Ensure the driver class is loaded
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}

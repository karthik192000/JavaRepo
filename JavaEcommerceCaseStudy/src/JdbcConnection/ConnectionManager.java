package JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
    private static final String url = "jdbc:mysql://localhost:3306/e-commerce";
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "Karthik@020";
    private static Connection con;

    public ConnectionManager(){}

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. for example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }


}

package hospital.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connection;
    public Statement statement;

    public conn() {
        try {
            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOSPITAL_MANAGEMENT_SYSYTEM", "root", "Sitaram2004@");

            // Create the statement object
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        // Return the connection instance
        return connection;
    }
}

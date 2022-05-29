package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No driver", e);
        }
    }
    public static Connection getConnection() {
           Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.put("user", "postgres");
            properties.put("password", "lera");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", properties);
            return connection;
          } catch (SQLException throwables) {
            throw new RuntimeException("No connection", throwables);

        }
    }
}

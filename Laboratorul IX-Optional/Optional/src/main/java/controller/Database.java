package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    // Oracle connection
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "JAVA";
    private static final String PASSWORD = "JAVA";
    ///prepare for the singleton
    private static Connection connection = null;

    private Database() {
    }

    public static Connection createConnection() {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, properties);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return conn;
    }

    /// other classes will call this method in order to connect to database
    public static Connection getConnection() {
        if (connection == null)
            connection = createConnection();

        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}

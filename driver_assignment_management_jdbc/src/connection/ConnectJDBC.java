package connection;

import java.sql.*;

public class ConnectJDBC {
    private static Connection conn = null;
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER_NAME = "hr";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        try {
            if (conn == null || conn.isClosed()) {
                openConnection();
            }
        } finally {
            conn.close();
        }
        return conn;
    }

    public static synchronized void openConnection() {
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBCConnection {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "hr";
        final String password = "123";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            System.out.println("Successful");
        } else {
            System.out.println("Fail");
        }
    }
}

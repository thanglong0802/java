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

    public static void main(String[] args) throws SQLException {
        Connection conn = ConnectJDBC.getConnection();
        // Bước 2: tạo cú pháp xử lý câu lệnh
        Statement statement = conn.createStatement();

        String selectSql = "SELECT * FROM DRIVER";

        ResultSet result = statement.executeQuery(selectSql);
        while (result != null && result.next()) {
            System.out.println("ID = " + result.getLong(1));
            System.out.println("Họ tên = " + result.getString(2));
            System.out.println("Địa chỉ = " + result.getString(3));
            System.out.println("Số điện thoại = " + result.getLong(4));
            System.out.println("Trình độ = " + result.getString(5));
            System.out.println("==========================");
            break;
        }
    }

}

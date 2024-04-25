package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class CSDL {
    private static final String SERVER = "localhost";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";
    private static final String DB_NAME = "QLLS";
    private static final String PORT = "1433";

    public static Connection getConnection() {
        Connection c = null;
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser(USER);
            ds.setPassword(PASSWORD);
            ds.setServerName(SERVER);
            ds.setDatabaseName(DB_NAME);
            ds.setTrustServerCertificate(true);
            ds.setPortNumber(Integer.parseInt(PORT));

            c = ds.getConnection();
            System.out.println("Connected");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public void addToDatabase(String playerName, int score) {
        Connection con = null;
        try {
            con = CSDL.getConnection();
            if (con != null) {
                String sql = "INSERT INTO DatabaseGame (Name, Score) VALUES (?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, playerName);
                stmt.setInt(2, score);
                int ketQua = stmt.executeUpdate();

                System.out.println("You have executed: "+ sql);
                System.out.println("There is a " + ketQua + " line changed!");
            } else {
                System.out.println("Connection failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con);
        }
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

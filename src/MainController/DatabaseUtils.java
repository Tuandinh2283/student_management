package MainController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tuandinh
 */
public class DatabaseUtils {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=qldsv;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection getDBConnect() throws SQLException {
        return getConnection();
    }
}

package bcsdbeginner.demo.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static bcsdbeginner.demo.jdbc.DBConnection.DBConnectionConstant.*;

public class DBConnectionManager {
    public static Connection getConnection() throws SQLException
    {
        try
        {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}

package bcsd.SpringVol2.DBConnection;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

import static bcsd.SpringVol2.DBConnection.DBConnectionConstant.*;

@Slf4j
public class DBConnectionManager {
    public static Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("connection={}", connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //반환
    public static void closeResource(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                log.error("error", e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                log.error("error", e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                log.error("error", e);
            }
        }
    }
}

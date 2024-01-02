package SpringMVC.jdbc.Repository;

import lombok.extern.slf4j.Slf4j;
import SpringMVC.jdbc.DBConnection.DBConnectionConstant;
import SpringMVC.jdbc.Domain.User;
import SpringMVC.jdbc.DBConnection.DBConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UserRepository {

    public User createUser(User user) throws SQLException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into User(userName, userId, userPw) values(?, ?, ?)";

        try
        {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserId());
            statement.setString(3, user.getUserPw());

            statement.executeUpdate();
            return user;
        }
        catch(SQLException e)
        {
            log.error("error = {} ", e);
            throw e;
        }
        finally
        {
            closeResource(connection, statement, null);
        }
    }
    public List<User> findAllUser() throws SQLException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from User";
        List<User> list = new ArrayList<>();
    try
    {
        connection = DBConnectionManager.getConnection();
        statement = connection.prepareStatement(sql);
        rs = statement.executeQuery();
        while(rs.next())
        {
            User user = new User();
            user.setUserName(rs.getString("UserName"));
            user.setUserId(rs.getString("UserId"));
            user.setUserPw(rs.getString("UserPw"));
            list.add(user);
        }
        return list;
    } catch (SQLException e)
    {
        log.error("error = {}", e);
        throw e;
    }
    finally {
        closeResource(connection, statement, rs);
    }
    }

    public User findById(String userId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from User where userId = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            rs = statement.executeQuery();
            User user = new User();

            while (rs.next()) {
                user.setUserName(rs.getString("UserName"));
                user.setUserId(rs.getString("UserId"));
                user.setUserPw(rs.getString("UserPw"));
            }
            return user;

        } catch (SQLException e) {
            log.error("error = {}", e);
            throw e;
        } finally {
            closeResource(connection, statement, rs);
        }
    }

    public void updateUsername(String userId, User updateuserId) throws SQLException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "update User set userName = ? where userId = ?";

        try
        {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, updateuserId.getUserName());
            statement.setString(2, userId);

            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            log.error("error = {}", e);
            throw e;
        }
        finally {
            closeResource(connection, statement, null);
        }
    }

    public void deleteUser(String userId) throws SQLException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "delete from User where userId = ?";

        try
        {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            log.error("error = {}", e);
            throw e;
        }
        finally
        {
            closeResource(connection, statement, null);
        }
    }
    private void closeResource(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        //반환할 때는 반드시 역순으로 반환해야 함.
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

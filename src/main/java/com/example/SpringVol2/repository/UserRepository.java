package com.example.SpringVol2.repository;

import com.example.SpringVol2.DBConnection.DBConnectionManager;
import com.example.SpringVol2.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Repository
public class UserRepository {
    public User createUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into users(email, password) values(?, ?)";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            log.error("createUser error={}", e);
            return null;
        } finally {
            closeResource(connection, statement, null);
        }
    }


    public List<User> findUsers() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from users";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            List<User> users = new ArrayList<>();


            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            log.error("selectUser error={}", e);
            return null;
        } finally {
            closeResource(connection, statement, rs);
        }
    }

    public User findUserByEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from users where email = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, email);

            rs = statement.executeQuery();
            User user = new User();

            while (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

            return user;
        } catch (SQLException e) {
            log.error("selectUser error={}", e);
            return null;
        } finally {
            closeResource(connection, statement, rs);
        }
    }

    public User updateUser(String email, User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "update users set email = ?, password = ? where email = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, email);

            return user;

        } catch (SQLException e) {
            log.error("updateUser error={}", e);
            return null;
        } finally {
            closeResource(connection, statement, null);
        }
    }

    public int deleteUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "delete from users where email = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, user.getEmail());

            statement.executeUpdate();
            return 0;
        } catch (SQLException e) {
            log.error("deleteUser error={}", e);
            return 1;
        } finally {
            closeResource(connection, statement, null);
        }
    }


    private void closeResource(Connection connection, PreparedStatement statement, ResultSet rs) {
        //반환할 때는 반드시 역순으로 반환해야 함.
        if (rs != null) {
            try {
                rs.close();
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

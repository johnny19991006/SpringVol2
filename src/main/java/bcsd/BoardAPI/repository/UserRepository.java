package bcsd.BoardAPI.repository;

import bcsd.BoardAPI.DBConnection.DBConnectionManager;
import bcsd.BoardAPI.domain.User;
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
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from users";//DB에 넘길 SQL 작성

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("id"));
                user.setUserName(rs.getString("username"));
                user.setUserEmail(rs.getString("email"));
                user.setUserPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            log.error("selectUser error={}", e);
        } finally {
            closeResource(connection, statement, rs);//사용한 리소스 반환
        }
        return userList;
    }

    public User createUser(User newUser) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into users(id, username, email, password) values(?, ?, ?, ?)";//DB에 넘길 SQL 작성

        try {
            connection = DBConnectionManager.getConnection();//DriverManger 통해서 DB커넥션 생성
            statement = connection.prepareStatement(sql);//SQL실행 하기위한 객체 PrepareStatement 생성

            statement.setString(1, newUser.getUserId());//DB컬럼과 자바 오브젝트 필드 바인딩
            statement.setString(2, newUser.getUserName());
            statement.setString(3, newUser.getUserEmail());
            statement.setString(4, newUser.getUserPassword());

            statement.executeUpdate();

        } catch (SQLException e) {
            log.error("createUser error={}", e);
        } finally {
            closeResource(connection, statement, null);//사용한 리소스 반환
        }
        return newUser;
    }

    public User findById(String userId) {
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from users where id = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);

            rs = statement.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getString("id"));
                user.setUserName(rs.getString("username"));
                user.setUserEmail(rs.getString("email"));
                user.setUserPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            log.error("selectUser error={}", e);
        } finally {
            closeResource(connection, statement, rs);//사용한 리소스 반환
        }
        return user;
    }

    public void updateUsername(String id, User newUser) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "update users set username = ?, email = ?, password = ? where id = ?";

        try {
            connection = DBConnectionManager.getConnection();//DriverManger 통해서 DB커넥션 생성
            statement = connection.prepareStatement(sql);//SQL실행 하기위한 객체 PrepareStatement 생성

            statement.setString(1, newUser.getUserName());//DB컬럼과 자바 오브젝트 필드 바인딩
            statement.setString(2, newUser.getUserEmail());
            statement.setString(3, newUser.getUserPassword());
            statement.setString(4, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("updateUser error={}", e);
        } finally {
            closeResource(connection, statement, null);//사용한 리소스 반환
        }
    }

    public void deleteUser(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "delete from users where id = ?";

        try {
            connection = DBConnectionManager.getConnection();//DriverManger 통해서 DB커넥션 생성
            statement = connection.prepareStatement(sql);//SQL실행 하기위한 객체 PrepareStatement 생성

            statement.setString(1, id);//DB컬럼과 자바 오브젝트 필드 바인딩

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("deleteUser error={}", e);
        } finally {
            closeResource(connection, statement, null);//사용한 리소스 반환
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

package bcsd.SpringVol2.repository;

import bcsd.SpringVol2.DBConnection.DBConnectionManager;
import bcsd.SpringVol2.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static bcsd.SpringVol2.DBConnection.DBConnectionManager.closeResource;

@Slf4j
@Repository
public class UserRepository {

    public UserDTO createUser(UserDTO user) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into users(username, userid, password) values(?, ?, ?)";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserId());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
            return user;

        } catch (SQLException e) {
            log.error("createUser error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, null);//사용한 리소스 반환
        }
    }

    public List<UserDTO> findAllUsers() throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from users";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);
            List<UserDTO> users = new ArrayList<>();

            rs = statement.executeQuery();
            while (rs.next()){
                users.add(new UserDTO(rs.getString("username"),
                        rs.getString("userid"),
                        rs.getString("password")));
            }
            return users;

        } catch (SQLException e) {
            log.error("selectUser error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, rs);//사용한 리소스 반환
        }
    }

    public UserDTO findByUserId(String userId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "select * from users where userid = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);

            rs = statement.executeQuery();

            UserDTO user = new UserDTO();
            while (rs.next()) {
                user.setUserName(rs.getString("username"));
                user.setUserId(rs.getString("userid"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            log.error("selectUser error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, rs);//사용한 리소스 반환
        }
    }

    //회원 정보 수정
    public void updateUserInfo(String userId, UserDTO user) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "update users set username = ?, password = ? where userid = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("updateUser error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, null);//사용한 리소스 반환
        }
    }

    public void deleteUser(String userId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "delete from users where userid = ?";

        try {
            connection = DBConnectionManager.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("deleteUser error={}", e);
            throw e;
        } finally {
            closeResource(connection, statement, null);//사용한 리소스 반환
        }
    }
}

package bcsd.BoardAPI.repository;

import bcsd.BoardAPI.DBConnection.DBConnectionManager;
import bcsd.BoardAPI.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();

    @BeforeEach
    void clearDB() throws SQLException {
        Helper.clearDB();
    }

    @Test
    void createUser() throws SQLException {
        User user1 = new User("userIdA", "userA", "bcsd@koreatech.ac.kr", "1111");
        User newUser = userRepository.createUser(user1);
        assertThat(newUser.getUserName()).isEqualTo("userA");
    }

    @Test
    void findById() throws SQLException {
        User user1 = new User("userIdA", "userA", "bcsdlab@koreatech.ac.kr", "1111");
        User newUser = userRepository.createUser(user1);

        User findUser = userRepository.findById("userIdA");

        assertThat(findUser.getUserId()).isEqualTo("userIdA");
    }

    @Test
    void updateUsername() throws SQLException {
        User user1 = new User("userIdA", "userA", "bcsdlab@koreatech.ac.kr", "1111");
        userRepository.createUser(user1);

        userRepository.updateUsername("userIdA",
                new User("userIdA", "userB", "userB@koreatech.ac.kr", "1234"));
        User updateUser = userRepository.findById("userIdA");
        assertThat(updateUser.getUserName()).isEqualTo("updateA");
    }

    @Test
    void deleteUser() throws SQLException {
        userRepository.deleteUser("userIdA");

        String deleteId = userRepository.findById("userIdA").getUserId();

        assertThat(deleteId).isEqualTo("");
    }

    static class Helper {
        public static void clearDB() throws SQLException {
            Connection connection = null;
            Statement statement = null;
            String sql1 = "delete from users";
            String sql2 = "alter table users AUTO_INCREMENT = 1";//DB에 넘길 SQL 작성

            try {
                connection = DBConnectionManager.getConnection();//DriverManger 통해서 DB커넥션 생성
                statement = connection.createStatement();//SQL실행 하기위한 객체 PrepareStatement 생성

                statement.addBatch(sql1);
                statement.addBatch(sql2);

                statement.executeBatch();
            } catch (SQLException e) {
                throw e;
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Exception e) {
                    }
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}
package SpringMVC.jdbc.Service;

import SpringMVC.jdbc.Domain.User;
import SpringMVC.jdbc.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public User createUser(User user) throws SQLException
    {
        return userRepository.createUser(user);
    }

    public List<User> findAllUser() throws SQLException
    {
        return userRepository.findAllUser();
    }

    public User findById(String userId) throws SQLException
    {
        return userRepository.findById(userId);
    }

    public void updateUsername(String userId, User user) throws SQLException
    {
        userRepository.updateUsername(userId, user);
    }

    public void deleteUser(String userId) throws SQLException
    {
        userRepository.deleteUser(userId);
    }
}

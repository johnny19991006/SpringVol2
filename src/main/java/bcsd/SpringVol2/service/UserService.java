package bcsd.SpringVol2.service;

import bcsd.SpringVol2.dto.UserDTO;
import bcsd.SpringVol2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO user) throws SQLException {
        return userRepository.createUser(user);
    }

    public List<UserDTO> findAllUsers() throws SQLException{
        return userRepository.findAllUsers();
    }

    public UserDTO findByUserId(String userId) throws SQLException{
        return userRepository.findByUserId(userId);
    }

    public void updateUserInfo(String userId, UserDTO user) throws SQLException{
        userRepository.updateUserInfo(userId, user);
    }

    public void deleteUser(String userId) throws SQLException{
        userRepository.deleteUser(userId);
    }

}

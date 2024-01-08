package bcsd.SpringVol2.service;

import bcsd.SpringVol2.domain.dto.LoginRequest;
import bcsd.SpringVol2.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void insertUser(User user);

    List<User> findAllUsers();

    User findById(Long id);

    User findByName(String username);

    User findByUserId(String userid);

    void updateUserInfo(Long id, User newUser);

    void deleteUser(Long id);

    User login(LoginRequest loginRequest);
}
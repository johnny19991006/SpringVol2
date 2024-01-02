package bcsd.SpringVol2.user.service;

import bcsd.SpringVol2.user.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void insertUser(User user);

    List<User> findAllUsers();

    User findById(Long id);

    void updateUserInfo(User user);

    void deleteUser(Long id);
}

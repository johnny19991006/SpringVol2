package bcsd.SpringVol2.service;

import bcsd.SpringVol2.domain.entity.User;
import bcsd.SpringVol2.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    @Override
    public void insertUser(User user) { //회원가입
        try {
            if ((userMapper.findByName(user.getUsername()) == null) && (userMapper.findByUserId(user.getUserid())) == null) {
                userMapper.insertUser(user);
            } else {
                throw new IllegalStateException();
            }
        } catch(Exception e){
            log.error("Error insert user with username: {}", user.getUsername());
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public User findByUserId(String userid) {
        return userMapper.findByUserId(userid);
    }


    @Override
    public void updateUserInfo(Long id, User newUser) {
        try {
            User userT = userMapper.findById(id);

            if (userT != null) {
                userT.setUsername(newUser.getUsername());
                userT.setUserid(newUser.getUserid());
                userT.setPassword(newUser.getPassword());
                userMapper.updateUserInfo(userT);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            log.error("Error update user info with id : {}", id);
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            if (userMapper.findById(id) != null) {
                userMapper.deleteUser(id);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            log.error("Error delete user with id : {}", id);
        }
    }
}
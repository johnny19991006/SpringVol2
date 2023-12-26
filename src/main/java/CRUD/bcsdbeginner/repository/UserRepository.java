package CRUD.bcsdbeginner.repository;

import CRUD.bcsdbeginner.domain.UserDomain;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    // db 연동 코드들
    static public ArrayList<UserDomain> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDomain("황현식", "hwang", "1234"));
        users.add(new UserDomain("허준기", "HoHo", "4321"));
    }

    public UserDomain insertUser(UserDomain user){
        users.add(user);
        return user;
    }

    public List<UserDomain> getAllUsers(){
        return users;
    }

    public UserDomain getUserByUserId(String userId){
        return users.stream()
                .filter(userDomain -> userDomain.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDomain("","",""));
    }

    public void updateUserPw(String userId, UserDomain user){
        users.stream()
                .filter(userDomain -> userDomain.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDomain("","",""))
                .setUserPw(user.getUserPw());
    }

    public void deleteUser(String userId){
        users.removeIf(userDomain -> userDomain.getUserId().equals(userId));
    }
}

package bcsd.SpringVol2.repository;

import bcsd.SpringVol2.domain.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into users(username, userid, password) values(#{user.username}, #{userid}, #{password))")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    void insertUser(@Param("user") User user);

    @Select("select * from users")
    List<User> findAllUsers();

    @Select("select * from users where id=#{id}")
    User findById(@Param("id")Long id);

    @Select("select * from users where username=#{username}")
    User findByName(@Param("username") String username);

    @Select("select * from users where userid=#{userid}")
    User findByUserId(@Param("userid") String userid);

    @Update("update users set username=#{user.username}, userid=#{user.userid}, password=#{user.password} where id=#{user.id}")
    void updateUserInfo(User user);

    @Delete("delete from users where id=#{id}")
    void deleteUser(Long id);
}

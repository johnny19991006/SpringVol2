package bcsd.SpringVol2.user.dao;

import bcsd.SpringVol2.user.dto.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into users(username, userid, password) values(#{user.username}, #{user.userid}, #{user.password})")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    void insertUser(@Param("user") User user);

    @Select("select * from users")
    List<User> findAllUsers();

    @Select("select * from users where id = #{id}")
    User findById(@Param("id")Long id);

    @Update("update users set username=#{user.username}, userid=#{user.userid}, password=#{user.password} where id=#{user.id}")
    void updateUserInfo(User user);

    @Delete("delete from users where id=#{id}")
    void deleteUser(Long id);
}

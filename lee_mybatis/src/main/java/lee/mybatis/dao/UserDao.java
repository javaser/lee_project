package lee.mybatis.dao;

import lee.mybatis.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Lee
 * @since 2017/1/2
 */
public interface UserDao {

    @Insert("INSERT INTO user(username, birthday, sex, address) VALUES" +
            "(#{username}, #{birthday}, #{sex}, #{address})")
    public int add(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    public int deleteUserById(int id);

    @Update("UPDATE user SET username = #{username}, birthday = #{birthday}, " +
            "sex = #{sex}, address = #{address} WHERE id = #{id}")
    public int updateUser(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    public User getUserById(int id);

    @Select("SELECT * FROM user")
    public List<User> getAllUser();
}

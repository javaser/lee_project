package lee.mybatis.dao;

import lee.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author Lee
 * @since 2017/1/2
 */
public class UserDaoTest {

    SqlSessionFactory sessionFactory;

    @Before
    public void before() {
        String resource = "mybatis-config.xml";
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(resource);
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void getUserById() {
        SqlSession session = sessionFactory.openSession();
        String statement = "lee.mybatis.dao.UserDao.getUserById";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }

    @Test
    public void addUser() {
        SqlSession session = sessionFactory.openSession();
        String statement = "lee.mybatis.dao.UserDao.addUser";
        int result = session.insert(statement, new User(4, "xiaoli", new Date
                (), '男',
                "清华"));
        System.out.println(result);
    }

    @Test
    public void deleteUser() {
        SqlSession session = sessionFactory.openSession();
        String statement = "lee.mybatis.dao.UserDao.deleteUser";
        int result = session.delete(statement, 1);
        System.out.println(result);
    }

    @Test
    public void updateUserById() {
        SqlSession session = sessionFactory.openSession();
        String statement = "lee.mybatis.dao.UserDao.updateUserById";
        int result = session.update(statement, new User(1, "xiaoming", new
                Date(), '女',
                "北京大学"));
        System.out.println(result);
    }

    @Test
    public void getAllUser() {
        SqlSession session = sessionFactory.openSession();
        String statement = "lee.mybatis.dao.UserDao.getAllUser";
        List<User> users = session.selectList(statement);
        System.out.println(users);
    }
}

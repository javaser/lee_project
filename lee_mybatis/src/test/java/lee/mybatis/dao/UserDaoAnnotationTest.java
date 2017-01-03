package lee.mybatis.dao;

import lee.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

/**
 * @author Lee
 * @since 2017/1/3
 */
public class UserDaoAnnotationTest {

    SqlSession session;
    UserDao userDao;

    @Before
    public void before() {
        String resource = "mybatis-config.xml";
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(is);
        session = sessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void after() {
        session.commit();
        session.close();
    }

    @Test
    public void getAllUser() {
        System.out.println(userDao.getAllUser());
    }

    @Test
    public void getUserById() {
        System.out.println(userDao.getUserById(1));
    }

    @Test
    public void addUser() {
        User user = new User(3, "five", new Date(), '男', "广州大学");
        System.out.println(userDao.add(user));
    }

    @Test
    public void updateUser() {
        User user = new User(4,"four", new Date(), '男', "深圳大学");
        System.out.println(userDao.updateUser(user));
    }
}

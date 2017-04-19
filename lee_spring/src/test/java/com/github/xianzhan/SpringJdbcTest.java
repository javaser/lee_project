package com.github.xianzhan;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-jdbc.xml"})
public class SpringJdbcTest {

    private static final String PATH = "spring-jdbc.xml";
    private ApplicationContext ac = null;

    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext(PATH);
        System.out.println("Before");
    }

    @After
    public void after() {
        if (ac != null) {
            ac = null;
        }
        System.out.println("After");
    }

    @Test
    public void testDataSource() {
        DataSource dataSource = (DataSource) ac.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }
}

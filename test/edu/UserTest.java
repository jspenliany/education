package edu;

import edu.dao.IUserDao;
import edu.dao.Userinfo;
import edu.services.UserService;
import edu.services.UserServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void TestService()
    {
        Userinfo tmp = userService.login("teahan","han");
        if (tmp == null)
            System.out.println(" Error, username OR pwd is wrong");
        else
            System.out.println(tmp.getUsername());

        userService.deleteUser("tang");
    }

}

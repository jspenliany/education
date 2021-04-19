package edu.services;

import edu.dao.IUserDao;
import edu.dao.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created infos 2021/4/18---tomcat
 */

public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public Userinfo login(String uname, String pwd)
    {
        Userinfo tmp = new Userinfo();
        tmp.setUsername(uname);
        tmp.setUserpwd(pwd);
        userDao.FindUsersInfos(tmp);
        return null;
    }
}

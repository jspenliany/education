package edu.services;

import edu.dao.IUserDao;
import edu.dao.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created infos 2021/4/18---tomcat
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public Userinfo login(String uname, String pwd)
    {
        Userinfo tmp = new Userinfo();
        tmp.setUsername(uname);
        tmp.setUserpwd(pwd);
        List<Userinfo> ulist=userDao.FindUsersInfos(tmp);
        if (ulist == null)
            tmp=null;
        else
            tmp = ulist.get(0);
        return tmp;
    }
}

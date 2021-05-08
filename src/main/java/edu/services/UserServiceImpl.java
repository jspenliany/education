package edu.services;

import edu.dao.IUserDao;
import edu.dao.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println(" enter into UserServiceImpl...login...");
        Userinfo tmp = new Userinfo();
        tmp.setUsername(uname);
//        tmp.setUserpwd(pwd);
        List<Userinfo> ulist=userDao.SelectUsersInfos(tmp);

        for (Userinfo uin:ulist) {
            if (pwd.equals(uin.getUserpwd())){
                System.out.println("---------"+uin.getUsername() +" "+uin.getUserpwd());
            }
        }

        if (ulist == null)
            tmp=null;
        else if (ulist.size() < 1)
            tmp=null;
        else if (ulist.size() < 2)
            tmp=ulist.get(0);
        else
            tmp=null;
        return tmp;
    }

    @Override
    public boolean deleteUser(String uname)
    {
        Userinfo tmp = new Userinfo();
        tmp.setUsername(uname);
        int affectRows=userDao.DeleteOldUser(tmp);
        return (affectRows == 1);
    }
}

package edu.services;

import edu.dao.IUserDao;
import edu.dao.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * created infos 2021/4/18---tomcat
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public Userinfo login(Map<String, Object> map)
    {
        System.out.println(" enter into UserServiceImpl...login...");
        Userinfo tmp = new Userinfo();
        tmp.setUsername((String) map.get("username"));
//        tmp.setUserpwd(pwd);
        List<Userinfo> ulist=userDao.SelectUsersInfos(tmp);

        for (Userinfo uin:ulist) {
            if (((String) map.get("userpwd")).equals(uin.getUserpwd())){
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
    public boolean logout(Map<String, Object> map)
    {
        System.out.println(" leaving the system...");
        Userinfo tmp = new Userinfo();
        tmp.setUsername((String) map.get("username"));
        tmp.setActive(false);
        tmp.setLastLogin(getCurrentTime());
//        tmp.setUserpwd(pwd);
        int affectRows=userDao.UpdateUserInfos(tmp);

        return (affectRows == 1);
    }

    @Override
    public boolean deleteUser(Map<String, Object> map)
    {
        Userinfo tmp = new Userinfo();
        Object[] keys = map.keySet().toArray();
        for (Object key: keys) {
            System.out.println(key.toString() + " " + map.get(key));

            if (key.toString().equals("username")){
                tmp.setUsername((String) map.get(key.toString()));
            }else if (key.toString().equals("study_id")){
                tmp.setUid((Integer) map.get(key.toString()));
            }else {

            }
        }

        int affectRows=userDao.DeleteOldUser(tmp);
        return (affectRows == 1);
    }
    @Override
    public boolean updateUser(Map<String, Object> map)
    {
        Userinfo tmp = new Userinfo();
        tmp.setUsername((String) map.get("username"));
        tmp.setActive((Boolean) map.get("active"));
        int affectRows=userDao.UpdateUserInfos(tmp);
        return (affectRows == 1);
    }
    @Override
    public boolean addUser(Map<String, Object> map)
    {
        Userinfo tmp = new Userinfo();
        tmp.setUsername((String) map.get("username"));
        tmp.setActive(true);
        int affectRows=userDao.UpdateUserInfos(tmp);
        return (affectRows == 1);
    }
    @Override
    public Userinfo queryProfile(Map<String, Object> map)
    {
        Userinfo tmp = new Userinfo();
        tmp.setUsername((String) map.get("username"));
        tmp.setActive(true);
        int affectRows=userDao.UpdateUserInfos(tmp);
        return tmp;
    }


    private Date getCurrentTime()
    {
        Date ctime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String ftime=sdf.format(ctime);
        try{
            ctime=sdf.parse(ftime);
        }catch (ParseException e)
        {
            e.printStackTrace();
        }
        java.sql.Date dtime = new java.sql.Date(ctime.getTime());
        return dtime;
    }
}

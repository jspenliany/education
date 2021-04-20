package edu.services;

import edu.dao.Userinfo;

/**
 * created infos 2021/4/18---tomcat
 */

public interface UserService {
    Userinfo login(String uname, String pwd);

    boolean deleteUser(String uname);
}

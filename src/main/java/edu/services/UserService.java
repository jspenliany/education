package edu.services;

import edu.dao.Userinfo;
import javafx.util.Pair;

import java.util.Map;

/**
 * created infos 2021/4/18---tomcat
 */

public interface UserService {
    Userinfo login(Map<String,Object> user);

    boolean logout(Map<String,Object> user);

    boolean deleteUser(Map<String,Object> user);

    boolean updateUser(Map<String,Object> user);

    boolean addUser(Map<String,Object> user);

    Userinfo queryProfile(Map<String,Object> user);
}

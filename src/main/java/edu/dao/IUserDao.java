package edu.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created infos 2021/1/1---tomcat
 */

public interface IUserDao {
    List<Userinfo> ShowUsersInfos(@Param("roleCode") int roleCode);

    int InsertNewUser(Userinfo userinfo);

    int DeleteOldUser(Userinfo userinfo);

    int UpdateUserInfos(Userinfo userinfo);

    List<Userinfo> SelectUsersInfos(Userinfo userinfo);

    Integer GetNextID(@Param("idType") int idType);

    Integer MatchColumnValue(@Param("search") String search, @Param("matchCode") int mcode);

}

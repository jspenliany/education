package edu.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created infos 2021/1/1---tomcat
 */

public interface IUserDao {
    public List<Userinfo> ShowUsersInfos(@Param("roleCode") int roleCode);

    public int InsertNewUser(Userinfo userinfo);

    public int DeleteOldUser(Userinfo userinfo);

    public int UpdateUserInfos(Userinfo userinfo);

    public List<Userinfo> FindUsersInfos(Userinfo userinfo);

    public Integer GetNextID(@Param("idType") int idType);

    public Integer MatchColumnValue(@Param("search") String search, @Param("matchCode") int mcode);

}

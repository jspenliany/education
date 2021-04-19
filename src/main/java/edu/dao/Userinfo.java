package edu.dao;

import java.io.Serializable;
import java.util.Date;

/**
 * created infos 2021/1/1---tomcat
 */

public class Userinfo implements Serializable {
    private static final long serialVersionUID=115118687516227665L;
    private Integer id;
    private Integer userid;
    private String username;
    private String userpwd;
    private String email;
    private String sex;
    private String role;
    private boolean active;
    private Date    lastLogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return userid;
    }

    public void setUid(Integer uid) {
        this.userid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                ", lastLogin=" + lastLogin +
                '}';
    }
}

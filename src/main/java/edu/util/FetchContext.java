package edu.util;

import edu.dao.Userinfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * created infos 2021/4/6---tomcat
 */

public class FetchContext {
    public static HttpServletRequest getCurrentRequest()
    {
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    public static Userinfo getCurrentUser()
    {
        return (Userinfo)(getCurrentRequest().getSession().getAttribute("user"));
    }
}

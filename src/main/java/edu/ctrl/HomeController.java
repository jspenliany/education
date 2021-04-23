package edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * created infos 2021/1/16---tomcat
 */
@Controller
public class HomeController {
    @RequestMapping("/homee")
    public String welcome(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String loginInfo = (String) session.getAttribute("loginInfo");
        if (loginInfo != null && loginInfo.equals("")){
            request.setAttribute("loginInfo",loginInfo);
        }

        return "index";
    }

    @RequestMapping("/")
    public String home()
    {
        return "forward:/home";
    }

    @RequestMapping("/requserinfo")
    public String getUserInfo()
    {
        return "report/showUser";
    }

    @RequestMapping("/loginrequest")
    public String getLogin(){ return "forward:/user/loginrequest";}

}

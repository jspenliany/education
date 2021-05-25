package edu.ctrl;

import edu.dao.Userinfo;
import edu.services.UserService;
import edu.services.UserServiceImpl;
import edu.util.FrontMsg;
import edu.util.UserParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/loginrespond", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String userpwd, boolean hidden, String dCode, HttpServletRequest request)
    {
        boolean check_flag = false;
        boolean logInfo_exist = false;

        List<FrontMsg> msg_code = new ArrayList<>();
        FrontMsg frontMsg;

        HttpSession session = request.getSession(true);
        Userinfo userinfo = (Userinfo) session.getAttribute("userInfo");

        Map<String, Object> map = new HashMap<String, Object>();

        if (userinfo !=null){
            logInfo_exist=true;
            if (userinfo.getUsername().equals(username)){
                frontMsg = new FrontMsg(UserParameters.MSG_CODE_REQUEST_LOG_IN,UserParameters.MSG_CODE_REQUEST_SUCCESS);
                msg_code.add(frontMsg);
            }else {
                logInfo_exist=false;
                session.removeAttribute("userInfo");
            }
        }

        if (!logInfo_exist){
            if (filterInput(username))
            {
                System.out.println("well, check finished " + username);
                frontMsg = new FrontMsg(UserParameters.MSG_CODE_INPUT_USERNAME,UserParameters.MSG_CODE_INPUT_OK);
                check_flag=true;
            }
            else
            {
                System.out.println("error, bad input " + username);
                frontMsg = new FrontMsg(UserParameters.MSG_CODE_INPUT_USERNAME,UserParameters.MSG_CODE_INPUT_ERROR);
            }

            msg_code.add(frontMsg);

            if (check_flag){
                map.put("username",username);
                map.put("userpwd",userpwd);
                userinfo = userService.login(map);

                if (userinfo == null){
                    frontMsg = new FrontMsg(UserParameters.MSG_CODE_REQUEST_LOG_IN,UserParameters.MSG_CODE_REQUEST_NO_RECORD);
                }else {
                    if (userinfo.getUserpwd().equals(userpwd)) {
                        frontMsg = new FrontMsg(UserParameters.MSG_CODE_REQUEST_LOG_IN, UserParameters.MSG_CODE_REQUEST_SUCCESS);
                        session.setAttribute("userInfo", userinfo);
                        userService.updateUser(map);
                    }else
                        frontMsg = new FrontMsg(UserParameters.MSG_CODE_INPUT_USER_PWD,UserParameters.MSG_CODE_INPUT_ERROR);
                }
                msg_code.add(frontMsg);
            }
        }

        return UserParameters.generateJSON(msg_code);
    }

    protected boolean filterInput(String inSTR)
    {
        String tmp = inSTR.trim();
        String regex = "^[a-zA-z0-9\u4E00-\u9FA5]+$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tmp);
        return matcher.matches();
    }


}

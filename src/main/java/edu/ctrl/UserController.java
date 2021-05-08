package edu.ctrl;

import edu.dao.Userinfo;
import edu.services.UserService;
import edu.util.FrontMsg;
import edu.util.UserParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String login(String username, String userpwd, boolean hidden, String dCode)
    {
        boolean check_flag = false;
        Userinfo userinfo;
        List<FrontMsg> msg_code = new ArrayList<>();
        FrontMsg frontMsg;

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
            userinfo = userService.login(username,userpwd);

            if (userinfo == null){
                frontMsg = new FrontMsg(UserParameters.MSG_CODE_REQUEST_LOG_IN,UserParameters.MSG_CODE_REQUEST_NO_RECORD);
            }else {
                if (userinfo.getUserpwd().equals(userpwd))
                    frontMsg = new FrontMsg(UserParameters.MSG_CODE_REQUEST_LOG_IN,UserParameters.MSG_CODE_REQUEST_SUCCESS);
                else
                    frontMsg = new FrontMsg(UserParameters.MSG_CODE_INPUT_USER_PWD,UserParameters.MSG_CODE_INPUT_ERROR);
            }
            msg_code.add(frontMsg);
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

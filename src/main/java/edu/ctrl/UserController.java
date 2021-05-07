package edu.ctrl;

import edu.dao.Userinfo;
import edu.services.UserService;
import edu.util.FrontMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        StringBuilder msg_content= new StringBuilder();
        StringBuilder msg_url= new StringBuilder();
        int msg_code=0;
        FrontMsg frontMsg = new FrontMsg();

        if (filterInput(username))
        {
            System.out.println("well, check finished " + username);
            msg_content.append(" username check OK; ");
            check_flag=true;
        }
        else
        {
            System.out.println("error, bad input " + username);
            msg_code=606;
            msg_content.append(" username check BAD; ");
            msg_url.append(" homepage ");
        }

        if (check_flag){
            userinfo = userService.login(username,userpwd);

            if (userinfo == null){
                msg_code=505;
                msg_content.append(" password check BAD; ");
                msg_url.append(" pass ");
            }else {
                msg_code=200;
                msg_content.append(" log in; ");
                msg_url.append(" welcome; ");
            }
        }

        frontMsg.setMsg_code(msg_code);
        frontMsg.setMsg_url(msg_url.toString());
        frontMsg.setMsg_content(msg_content.toString());

        return frontMsg.toString();
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

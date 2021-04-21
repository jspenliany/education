package edu.ctrl;

import edu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/loginrespond", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, boolean hidden)
    {

        if (filterInput(username))
        {
            System.out.println("well, check finished " + username);
        }
        else
        {
            System.out.println("error, bad input " + username);
        }

        userService.login(username,password);
        ModelAndView model = new ModelAndView();
        model.setViewName("forward:/home");
        return model;
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

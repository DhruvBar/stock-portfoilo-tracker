package org.daiict.controller;

import org.daiict.model.UserDetail;
import org.daiict.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/signin")
    public String login()
    {
        return "login";
    }

    @GetMapping("/register")
    public String register()
    {
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDetail user, HttpSession session)
    {


        boolean f = userService.checkEmail(user.getEmail());
        if(f)
        {
            session.setAttribute("msg","Email Id already exists");
        }
        else
        {
            UserDetail userDetail = userService.createUser(user);
            if(userDetail!=null)
            {
                session.setAttribute("msg","Registered successfully");
            }
            else
            {
                session.setAttribute("msg","Something Error in server");
            }

        }
        return "redirect:/register";
    }


}

package org.daiict.authn_authz.controller;

import org.daiict.authn_authz.model.UserDetail;
import org.daiict.authn_authz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String createuser(@ModelAttribute UserDetail user)
    {
        UserDetail userDetail = userService.createUser(user);

        boolean f = userService.checkEmail(user.getEmail());
        if(f)
        {
            System.out.println("Email id already exists");
        }
        else
        {
            if(userDetail!=null)
            {
                System.out.println("Register Successfully");
            }
            else
            {
                System.out.println("Something error in server");
            }

        }
        return "redirect:/register";
    }


}

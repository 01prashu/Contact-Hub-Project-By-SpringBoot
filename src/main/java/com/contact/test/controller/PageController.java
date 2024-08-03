package com.contact.test.controller;

import com.contact.test.entities.User;
import com.contact.test.repository.UserRepository;
import com.contact.test.service.UserContactServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserContactServiceImpl userContactService;

    @Autowired
    UserRepository userRepository;
    @GetMapping("/test2")
    public  String Dotest()
    {
        return "Hello";
    }

    @GetMapping("/home")
    public String getHome()
    {
        return "index";
    }

    @GetMapping("/register")
    public String getRegister(Model model)
    {
        model.addAttribute("user",new User());
        return "registration";
    }

    @GetMapping("/login")
    public String getLogin()
    {
        return "login";
    }

    @PostMapping("/signup-handler")
    public String RegistrationHandler(@ModelAttribute("user") User user , @RequestParam(value="agreement"
            , defaultValue = "false")boolean agreement
            , Model model
    , HttpSession session)
    {
       try {
           if(!agreement)
           {
               System.out.println("You have not agreed terms and condition");
               return "registration";
           }
           user.setImage("profile.png");
           userContactService.CreateUser(user);
           return "Sucess";
       }
       catch (Exception e)
       {
           e.printStackTrace();
           model.addAttribute("user",user);
          session.setAttribute("message","Something went wrong check the filed you have filled!");
           return "registration";
       }
    }
    @GetMapping("/test")
    public String doTest()
    {
        return "dummy";
    }

    @GetMapping("/handle-signIn")
    public String HandleLogin(Model model) {
        model.addAttribute("login",true);
        System.out.println("Login Successfully");
        return "redirect:/home";
    }
//    @GetMapping("/logout")
//    public String HandleLogout(Model model) {
//        model.addAttribute("login",false);
//        return "redirect:/home";
//    }
}

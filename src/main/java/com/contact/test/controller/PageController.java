package com.contact.test.controller;

import com.contact.test.entities.User;
import com.contact.test.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

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
        return "SignIn";
    }

//    @PostMapping("/signup-handler")
//    public String RegistrationHandler(@ModelAttribute("user") User user , @RequestParam(value="agreement"
//            , defaultValue = "false")boolean agreement
//            , Model model
//    , HttpSession session)
//    {
//       try {
//           if(!agreement)
//           {
//               System.out.println("You have not agreed terms and condition");
//               return "registration";
//           }
//           user.setImageurl(" ");
//           user.setRole("NORMAL_USER");
//
//
//           boolean userStore=true;
//           model.addAttribute("user",new User());
//           session.setAttribute("message","You are successfully registered ! Got to login page");
//           model.addAttribute("status", true);
//           return "Sucess";
//       }
//       catch (Exception e)
//       {
//           e.printStackTrace();
//           model.addAttribute("user",user);
//          session.setAttribute("message","Something went wrong check the filed you have filled!");
//           return "registration";
//       }
//    }
    @GetMapping("/test")
    public String doTest()
    {
        return "dummy";
    }
}

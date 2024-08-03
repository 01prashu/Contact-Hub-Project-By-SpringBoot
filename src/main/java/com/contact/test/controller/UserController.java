package com.contact.test.controller;

import com.contact.test.entities.User;
import com.contact.test.service.UserContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserContactServiceImpl userContactService;
    @GetMapping("/")
    public String getIndex()
    {
        return "This is home";
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user , BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            System.out.println(bindingResult);
        }
        try {
            userContactService.CreateUser(user);
            return new  ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            return null;
        }

    }
}

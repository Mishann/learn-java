package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
    }

    @GetMapping(name = "/")
    public void action() {
//
//        User u = new User();
//        u.setFirstName("asd");
//        u.setLastName("asd");
//
//        userService.add(u);

        List<User> users = userService.findAll();

        System.out.println("Action");
        System.out.println("Action");
        System.out.println("Action");
        System.out.println("Action");
        System.out.println("Action");

    }

}

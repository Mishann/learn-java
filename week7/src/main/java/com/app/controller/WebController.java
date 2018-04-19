package com.app.controller;

import com.app.model.User;
import com.app.service.FactoryService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class WebController {
    @Autowired
    private UserService userService;

    @Autowired
    private FactoryService factoryService;

    @PostConstruct
    public void init() {
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody User u) {
        userService.add(u);
    }

    @GetMapping("/factory/{fId}")
    public ResponseEntity<List<User>> getAllUsersByFactory(@PathVariable String fId) {
        List<User> users = factoryService.getAllUsersByFactory(fId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
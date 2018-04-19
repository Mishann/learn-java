package com.app.week8.controller;

import com.app.week8.rest.dto.UserDto;
import com.app.week8.utils.RestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
public class WebController {

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserDto u) throws URISyntaxException {
        RestUtils.addUser("http://localhost:8080/addUser", u);
    }

    @GetMapping("/factory/{fId}")
    public List<UserDto> getAllUsersByFactory(@PathVariable String fId) throws URISyntaxException {
        return RestUtils.getAllUsersByFactory("http://localhost:8080/factory", fId);
    }
}

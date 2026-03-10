package com.devops.user_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "User Service Running";
    }

    @GetMapping("/users")
    public String users() {
        return "Users endpoint working";
    }
}
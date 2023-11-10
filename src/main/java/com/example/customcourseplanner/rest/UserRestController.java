package com.example.customcourseplanner.rest;

import com.example.customcourseplanner.model.User;
import com.example.customcourseplanner.service.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserRestController {
    private final UserServiceImpl userService;

    public UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> getAll() {
        return userService.getAllUsers();
    }
}

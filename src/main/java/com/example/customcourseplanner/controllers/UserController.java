package com.example.customcourseplanner.controllers;

import com.example.customcourseplanner.model.User;
import com.example.customcourseplanner.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        Optional<User> user = userService.getUserById(id);
        List<User> userList = new ArrayList<>();
        user.ifPresent(userList::add);
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/new_user")
    public String addUser() {
        return "/newUser";
    }

    @PostMapping("/new_user")
    public String userPostAdd(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        Optional<User> user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/users/{id}/edit")
    public String userPostEdit(@PathVariable("id") long id, @ModelAttribute User updatedUser) {
        userService.editUser(updatedUser, id);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String userPostDelete(@PathVariable long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}

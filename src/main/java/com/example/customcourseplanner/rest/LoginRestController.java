package com.example.customcourseplanner.rest;

import com.example.customcourseplanner.model.Login;
import com.example.customcourseplanner.service.LoginServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class LoginRestController {
    private final LoginServiceImpl loginService;

    LoginRestController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/logins")
    List<Login> getAll() {
        return loginService.getAllLogins();
    }
}

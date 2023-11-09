package com.example.customcourseplanner.service.api;

import com.example.customcourseplanner.model.Login;

import java.util.List;
import java.util.Optional;

public interface LoginService {
    Login addLogin(Login login);
    void deleteLoginById(long id);
    Optional<Login> getLoginById(long id);
    Login editLogin(Login login);
    List<Login> getAllLogins();
}

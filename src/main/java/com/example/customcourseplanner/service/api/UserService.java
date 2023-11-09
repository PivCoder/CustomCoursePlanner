package com.example.customcourseplanner.service.api;

import com.example.customcourseplanner.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    void deleteUserById(long id);
    Optional<User> getUserById(long id);
    User editUser(User user);
    List<User> getAllUsers();
}

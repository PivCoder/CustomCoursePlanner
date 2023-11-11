package com.example.customcourseplanner.service;

import com.example.customcourseplanner.model.User;
import com.example.customcourseplanner.repositoryes.UserRepository;
import com.example.customcourseplanner.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User editUser(User newUser, long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setSurname(newUser.getSurname());
                    user.setRole(newUser.getRole());
                    user.setJob(newUser.getJob());
                    user.setMentor(newUser.getMentor());
                    user.setArchived(newUser.isArchived());
                    return userRepository.save(user);
                })
                .orElseGet(() -> userRepository.save(newUser));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

package com.example.customcourseplanner.service;

import com.example.customcourseplanner.model.Login;
import com.example.customcourseplanner.repositoryes.LoginRepository;
import com.example.customcourseplanner.service.api.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public void deleteLoginById(long id) {
        loginRepository.deleteById(id);
    }

    @Override
    public Optional<Login> getLoginById(long id) {
        return loginRepository.findById(id);
    }

    @Override
    public Login editLogin(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }
}

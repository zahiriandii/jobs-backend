package com.example.jobapplication.Service.Implementation;

import com.example.jobapplication.Model.User;
import com.example.jobapplication.Repository.UserRepository;
import com.example.jobapplication.Service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService
{

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User logIn(String email, String password) {
        if (email != null && password != null)
        {
            return this.userRepository.findByEmailAndPassword(email,password).orElseThrow(()->new RuntimeException());
        }
        else {
            throw new RuntimeException();
        }
    }

    @Override
    public User register(String email, String password) {
        User user = new User(email,password);
        if (email != null && password != null)
        {
            return this.userRepository.save(user);
        }
        else
        {
            throw new RuntimeException();
        }
    }
}

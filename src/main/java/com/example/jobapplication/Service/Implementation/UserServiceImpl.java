package com.example.jobapplication.Service.Implementation;

import com.example.jobapplication.Model.User;
import com.example.jobapplication.Repository.UserRepository;
import com.example.jobapplication.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(String email, String password) {
        User user = new User(email,password);
        return userRepository.save(user);
    }
}

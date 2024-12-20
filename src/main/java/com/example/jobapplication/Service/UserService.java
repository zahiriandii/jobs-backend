package com.example.jobapplication.Service;

import com.example.jobapplication.Model.User;

public interface UserService
{
    User saveUser (String email, String password);
}

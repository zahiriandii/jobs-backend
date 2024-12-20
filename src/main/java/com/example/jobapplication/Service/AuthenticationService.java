package com.example.jobapplication.Service;

import com.example.jobapplication.Model.User;

public interface AuthenticationService
{
   User logIn(String email, String password);
   User register(String email,String password);
}

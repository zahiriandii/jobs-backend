package com.example.jobapplication.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;


   public User(String email,String password)
    {
        this.email=email;
        this.password=password;
    }

   public User ()
    {

    }
    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

}

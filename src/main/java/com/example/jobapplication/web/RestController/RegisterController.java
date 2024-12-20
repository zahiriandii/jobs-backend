package com.example.jobapplication.web.RestController;

import com.example.jobapplication.Model.User;
import com.example.jobapplication.Service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class RegisterController {
    private final AuthenticationService authenticationService;

    public RegisterController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register (@RequestBody User user)
    {
        try
        {
            User registeredUser = this.authenticationService.register(user.getEmail(), user.getPassword());
            return ResponseEntity.ok(registeredUser);
        }
        catch (RuntimeException e)
        {
            return  ResponseEntity.badRequest().build();
        }
    }
}







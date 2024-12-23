package com.example.jobapplication.web.RestController;

import com.example.jobapplication.Model.User;
import com.example.jobapplication.Service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class LogInController
{
   private final AuthenticationService authenticationService;

    public LogInController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/logIn")
    public ResponseEntity<User> logIn (@RequestBody User user, HttpServletRequest req)
    {
        try
        {
            User loggedInUser = this.authenticationService.logIn(user.getEmail(), user.getPassword());
            req.getSession().setAttribute("user",loggedInUser);
            return ResponseEntity.ok(loggedInUser);
        }
        catch (RuntimeException e)
        {
           return ResponseEntity.notFound().build();
        }


    }

}

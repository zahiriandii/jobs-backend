package com.example.jobapplication.web.RestController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class LogOutController
{

    @PostMapping ("/logOut")
    public ResponseEntity<String> logOut (HttpServletRequest req)
    {
         try
         {
             req.getSession().invalidate();
             return ResponseEntity.ok("Loggout Success");
         }
         catch (RuntimeException e)
         {
             return ResponseEntity.badRequest().build();
         }
    }

}

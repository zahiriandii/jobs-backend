package com.example.jobapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()  // Disable CSRF for now (enable it in production)
                .authorizeRequests()
                .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/auth/logIn").permitAll()
                .requestMatchers(HttpMethod.GET,"/jobs/allJobs").permitAll()
                .requestMatchers(HttpMethod.GET,"/jobs/{jobId}").permitAll()
                .requestMatchers(HttpMethod.POST,"/jobs").permitAll()
                .requestMatchers(HttpMethod.PUT,"/jobs/{jobId}").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/jobs/{jobId}").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/auth/logOut").permitAll()// Allow registration without auth
                .anyRequest().authenticated();  // Any other requests need to be authenticated

        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173");  // Allow requests from the frontend
        config.addAllowedHeader("*");  // Allow all headers
        config.addAllowedMethod("*");  // Allow all HTTP methods
        source.registerCorsConfiguration("/**", config);  // Apply to all endpoints
        return source;
    }
}

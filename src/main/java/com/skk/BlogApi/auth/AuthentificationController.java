package com.skk.BlogApi.auth;

import com.skk.BlogApi.auth.dto.AuthResponse;
import com.skk.BlogApi.auth.dto.LoginRequest;
import com.skk.BlogApi.auth.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthentificationController {
    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping("/register")
    AuthResponse register(@RequestBody RegisterRequest registerRequest){
        return authentificationService.Register(registerRequest) ;
    }

    @PostMapping("/login")
    AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authentificationService.Login(loginRequest);
    }
}

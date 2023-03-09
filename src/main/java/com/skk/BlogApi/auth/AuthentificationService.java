package com.skk.BlogApi.auth;

import com.skk.BlogApi.auth.dto.AuthResponse;
import com.skk.BlogApi.auth.dto.LoginRequest;
import com.skk.BlogApi.auth.dto.RegisterRequest;
import com.skk.BlogApi.config.JwtService;
import com.skk.BlogApi.entity.User;
import com.skk.BlogApi.entity.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthentificationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
private PasswordEncoder passwordEncoder;
    @Autowired
private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthResponse Register(RegisterRequest registerRequest){
        System.out.println(registerRequest);
        var user = User.builder().username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .name(registerRequest.getName()).build();
        var userrespons = userRepository.save(user);
        var token= jwtService.generateToken(userrespons);


        return AuthResponse.builder().username(userrespons.getUsername())
                .Token(token).build();


    }

    public AuthResponse Login(LoginRequest loginRequest){
        System.out.println(loginRequest);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(

                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        var userespons= userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();

        var token= jwtService.generateToken(userespons);


        return AuthResponse.builder().username(userespons.getUsername())
                .Token(token).build();


    }

    User findOneuser(Long i){
        return  userRepository.getById(i);
    }



}

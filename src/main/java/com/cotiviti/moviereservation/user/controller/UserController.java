package com.cotiviti.moviereservation.user.controller;

import com.cotiviti.moviereservation.configuration.JwtTokenProvider;
import com.cotiviti.moviereservation.configuration.LoggedInUserDetail;
import com.cotiviti.moviereservation.user.dto.JWTLoginSucessReponse;
import com.cotiviti.moviereservation.user.dto.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cotiviti.moviereservation.configuration.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    public UserController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTLoginSucessReponse(true, jwt));
    }
    @GetMapping("/roles")
    public ResponseEntity<List<String>> getLoggedInUserRoles() {
        return new ResponseEntity(LoggedInUserDetail.getLoggedInUserRoles(), HttpStatus.OK);
    }
}

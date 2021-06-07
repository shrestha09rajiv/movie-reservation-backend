package com.cotiviti.moviereservation.user.service;

import com.cotiviti.moviereservation.user.domain.User;
import com.cotiviti.moviereservation.user.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("Wrong credentials"));
        return user.get();
    }

    public User loadUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
        return optionalUser.get();
    }
}

package com.api.tweteroo.Services;

import org.springframework.stereotype.Service;

import com.api.tweteroo.Repositories.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
}

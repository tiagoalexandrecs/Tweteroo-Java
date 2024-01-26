package com.api.tweteroo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.Services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    UserService userService;

    public void UserController(UserService userService) {
        this.userService = userService;
    }
}

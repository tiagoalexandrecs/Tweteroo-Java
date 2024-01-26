package com.api.tweteroo.Controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.Dtos.UserDto;
import com.api.tweteroo.Models.UserModel;
import com.api.tweteroo.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    UserService userService;

    public  void UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
        Optional<UserModel> user = userService.findById(id);

        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDto body) {
        Optional<UserModel> user = userService.save(body);
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("An user with this username already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}

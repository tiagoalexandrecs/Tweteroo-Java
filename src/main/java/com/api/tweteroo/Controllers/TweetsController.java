package com.api.tweteroo.Controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweteroo.Dtos.TweetDto;
import com.api.tweteroo.Dtos.UserDto;
import com.api.tweteroo.Models.TweetModel;
import com.api.tweteroo.Models.UserModel;
import com.api.tweteroo.Services.TweetsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    TweetsService tweetsService;

    public TweetsController(TweetsService tweetsService) {
        this.tweetsService = tweetsService;
    }

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDto body) {
        Optional<TweetModel> user = tweetsService.save(body);
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Thereś no user with this id");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

     @GetMapping
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(tweetsService.findAll());
    }

    
}

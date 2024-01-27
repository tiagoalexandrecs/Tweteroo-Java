package com.api.tweteroo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Object> getTweets() {
        return ResponseEntity.status(HttpStatus.OK).body(tweetsService.findAll());
    }

    @GetMapping("users/{userId}") 
    public ResponseEntity<Object> getTweetsByUserId(@PathVariable("userId") Long userId) {
        Optional<List <TweetModel> > tweets = tweetsService.findByUserId(userId);

        if (tweets.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(tweets);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is not an user under this Id");
        }
    }

    
}

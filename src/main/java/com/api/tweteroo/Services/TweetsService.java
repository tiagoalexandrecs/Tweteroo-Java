package com.api.tweteroo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.tweteroo.Dtos.TweetDto;
import com.api.tweteroo.Models.TweetModel;
import com.api.tweteroo.Models.UserModel;
import com.api.tweteroo.Repositories.TweetRepository;
import com.api.tweteroo.Repositories.UserRepository;

@Service
public class TweetsService {
    final TweetRepository tweetRepository;
    final UserRepository  userRepository;

    TweetsService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Optional<TweetModel> save(TweetDto dto) {
        Optional<UserModel> user = userRepository.findById(dto.getUserID());

        if (user.isPresent()){
            TweetModel tweet = new TweetModel(dto,user.get());
            return Optional.of(tweetRepository.save(tweet));
        } else {
            return Optional.empty();
        }

    }

    public List<TweetModel> findAll() {
        return tweetRepository.findAll();
    }

    


}

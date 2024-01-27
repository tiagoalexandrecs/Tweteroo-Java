package com.api.tweteroo.Models;


import com.api.tweteroo.Dtos.TweetDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "tweets")
public class TweetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column( length = 280, nullable = false)
    private String tweet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public TweetModel (TweetDto dto, UserModel user)  {
        this.tweet = dto.getTweet();
        this.user = user;
    }
}

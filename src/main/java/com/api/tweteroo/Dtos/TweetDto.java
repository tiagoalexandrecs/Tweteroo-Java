package com.api.tweteroo.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDto {

    @NotBlank
    @Size(max=280, message = "The maximum length is 280 characters, please sum it up")
    private String tweet;

    @NotBlank
    private Long userID;
    
}

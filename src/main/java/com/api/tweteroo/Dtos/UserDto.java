package com.api.tweteroo.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    
    @NotBlank
    private String avatar;

    @NotBlank
    @Size(max= 100, message = "Maximum length for username is 100 characters")
    private String username;
}

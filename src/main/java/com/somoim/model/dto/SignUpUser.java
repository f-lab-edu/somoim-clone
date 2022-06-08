package com.somoim.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
public class SignUpUser {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}

